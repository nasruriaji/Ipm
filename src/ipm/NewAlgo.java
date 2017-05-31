/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipm;

/**
 *
 * @author David
 */
public class NewAlgo {
    public static void main(String[] args) {
        double x[][] = {{1,1}};
        double v[][] = {{0.2,0.3,-0.1},{0.3,0.1,-0.1}};
        double vb[] = {-0.3,0.3,0.3};
        double w[][] = {{0.5,-0.3,-0.4}};
        double wb[] = {-0.1};
        double t[] = {0};
        double lr = 0.2;
        double mse[] = new double[10];
        int neuron_hidden = 3;
        int neuron_output = 1;
        int neuron_input = 2;
        int loop = 0;
        int epoch = 100;
        double target_error = 0.08;
        double last_mse = 0;
        
        do {
            for (int i = 0; i < 1; i++) {

                // Hitung hidden layer
                double z[] = new double[10];
                for (int j = 0; j < 3; j++) {
                    double z_net[] = new double[10];
                    double temp = 0;
                    for (int k = 0; k < 2; k++) {
                        // Cek logika Perkalian
                        // System.out.println(x[i][k]+" * "+v[k][j]);
                        // System.out.println(v[k][j]);
                        // System.out.println(x[i][k]);
                        // System.out.println("x["+i+""+k+"] v["+k+""+j+"]");

                        // Hitung z_net tanpa bias
                        temp = temp + (x[i][k] * v[k][j]);
                    }
                    // Hasil z_net + bias
                    z_net[j] = vb[j] + temp;
                    // System.out.println("z_net["+j+"] = "+z_net[j]);

                    // Hasil z dengan aktivasi sigmoid biner
                    z[j] = 1/(1+(Math.exp(-z_net[j])));
                    // System.out.println("z["+j+"] = "+z[j]);
                }

                // Hitung output layer
                double y[] = new double[10];
                for (int j = 0; j < 1; j++) {
                    double y_net[] = new double[10];
                    double temp = 0;

                    for (int k = 0; k < 3; k++) {
                        // Cek logika Perkalian
                        // System.out.println(z[k]+" * "+w[j][k]);
                        // System.out.println(w[j][k]);
                        // System.out.println(z[k]);
                        // System.out.println("z["+k+"] w["+j+""+k+"]");

                        // Cek z + v
                        // System.out.println(z[k]);
                        // System.out.println(w[j][k]);

                        // Hitung y_net tanpa bias
                        temp = temp + (z[k] * w[j][k]);
                    }
                    // Cek temp + bias
                    // System.out.println(temp);
                    // System.out.println(wb[j]);

                    // Hasil y_net + bias
                    y_net[j] = wb[j] + temp;
                    // System.out.println("y_net = "+y_net[j]);

                    // Hasil y dengan aktivasi sigmoid biner
                    y[j] = 1/(1+(Math.exp(-y_net[j])));
                    // System.out.println("y = "+y[j]);
                    
                    // MSE
                    mse[j] = (Math.pow((t[i] - y[j]), 2));
                    last_mse = mse[j];
                    System.out.println("MSE "+t[i]+" - "+y[j]+" = "+mse[j]);
                }

                // Hitung error y dan delta w
                double error_y[] = new double[10];
                double Aw[][] = new double[10][10];
                double Awb[] = new double[10];

                for (int j = 0; j < neuron_output; j++) {
                    // Error y
                    error_y[j] = (t[i] - y[j]) * y[j] * (1 - y[j]);
                    // System.out.println("Error output = "+error_y[j]);

                    for (int k = 0; k < neuron_hidden; k++) {
                        // Delta bobot
                        Aw[j][k] = lr * error_y[j] * z[k];
                        // System.out.println("Aw["+j+"]["+k+"] = "+Aw[j][k]);
                    }
                    // Delta bobot bias
                    Awb[j] = lr * error_y[j];
                    // System.out.println("Awb["+j+"] = "+Awb[j]);
                }

                // Hitung error y_net dan 
                double error_ynet[] = new double[10];
                double error_z[] = new double[10];
                double Av[][] = new double[10][10];
                double Avb[] = new double[10];

                for (int j = 0; j < neuron_hidden; j++) {
                    for (int k = 0; k < neuron_output; k++) {
                        // faktor kesalahan y_net
                        error_ynet[j] = error_y[k] * w[k][j];
                        // System.out.println("Error y_net = "+error_ynet[j]);
                    }
                    // faktor kesalahan z
                    error_z[j] = error_ynet[j] * z[j] * (1 - z[j]);
                    // System.out.println("Error z = "+error_z[j]);

                    for (int k = 0; k < neuron_input; k++) {
                        // Suku perubahan bobot hidden
                        Av[k][j] = lr * error_z[j] * x[i][k];
                        // System.out.println("Av["+k+""+j+"] = "+Av[k][j]);

                        // Cek logika
                        // System.out.println("Av["+k+"]["+j+"]  x["+i+"]["+k+"]");
                    }
                    // Suku perubahan bobot bias
                    Avb[j] = lr * error_z[j];
                    // System.out.println("Av["+j+"] = "+Avb[j]);
                }

                // update bobot output
                for (int j = 0; j < neuron_output; j++) {
                    for (int k = 0; k < neuron_hidden; k++) {
                        // update z
                        w[j][k] = w[j][k] + Aw[j][k];
                        // System.out.println(Aw[j][k]+" = "+w[j][k]);
                    }
                    // update bias
                    wb[j] = wb[j] + Awb[j];
                    // System.out.println(Awb[j]+" = "+wb[j]);
                }

                // update bobot hidden
                for (int j = 0; j < neuron_hidden; j++) {
                    for (int k = 0; k < neuron_input; k++) {
                        // update z
                        v[k][j] = v[k][j] + Av[k][j];
                        // System.out.println(Av[k][j]+" = "+v[k][j]);
                    }
                    // update bias
                    vb[j] = vb[j] + Avb[j];
                    // System.out.println(Avb[j]+" = "+vb[j]);
                }
            // Akhir for i
            }
        loop++;
        } while (loop < epoch && target_error < last_mse);
        System.out.println("Last MSE = "+last_mse);
        System.out.println("Epoch = "+loop);
    }
}
