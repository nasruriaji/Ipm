/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author David
 */
public class TesCode {
    
    public static void main(String[] args) {
        double x[][] = new double[50][50];
        double xNorm[][] = new double[50][50];
        double t[] = new double[50];
        int n = 0;
        
        Storage str = new Storage();
        int countRecords = str.countRecords();
        
        try {
            Statement stm = Koneksi.getConn().createStatement();
            ResultSet rsl = stm.executeQuery("select * from data_ipm");
            
            while (rsl.next()) {
                x[n][0] = rsl.getDouble("t5");
                x[n][1] = rsl.getDouble("t4");
                x[n][2] = rsl.getDouble("t3");
                x[n][3] = rsl.getDouble("t2");
                x[n][4] = rsl.getDouble("t1");
                x[n][5] = rsl.getDouble("t");
                n++;
            }
        
            rsl.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Gagal"+e);
        }
        
        for (int i = 0; i < countRecords; i++) {
            for (int j = 0; j < 6; j++) {
                xNorm[i][j] = ((0.8*(x[i][j]-str.nilaiMin(x, countRecords)))/(str.nilaiMax(x, countRecords)-str.nilaiMin(x, countRecords)))+0.1;
                t[i] = xNorm[i][5];
            }
        }
        
        double v[][] = new double[100][100];
        double vb[] = new double[100];
        double w[][] = new double[100][100];
        double wb[] = new double[100];
        
        double lr = 0.2;
        double mse[] = new double[10];
        int neuron_hidden = 3;
        int neuron_output = 1;
        int neuron_input = 5;
        int loop = 0;
        int epoch = 100;
        double target_error = 0.001;
        double last_mse = 0;
        
        for (int j = 0; j < neuron_hidden; j++) {
            for (int k = 0; k < neuron_input; k++) {
                v[j][k] = Math.random();
                // System.out.println("Bobot = "+v[j][k]);
            }
            vb[j] = Math.random();
            // System.out.println("Bias = "+vb[j]);
        }
        
        for (int j = 0; j < neuron_output; j++) {
            for (int k = 0; k < neuron_hidden; k++) {
                w[j][k] = Math.random();
                // System.out.println("Bobot = "+w[j][k]);
            }
            wb[j] = Math.random();
            // System.out.println("Bias = "+wb[j]);
        }
        
        do {
            for (int i = 0; i < countRecords; i++) {
                double z[] = new double[10];
                for (int j = 0; j < neuron_hidden; j++) {
                    double z_net[] = new double[10];
                    double temp = 0;
                    for (int k = 0; k < neuron_input; k++) {
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
                for (int j = 0; j < neuron_output; j++) {
                    double y_net[] = new double[10];
                    double temp = 0;

                    for (int k = 0; k < neuron_hidden; k++) {
                        temp = temp + (z[k] * w[j][k]);
                    }
                    y_net[j] = wb[j] + temp;
                    y[j] = 1/(1+(Math.exp(-y_net[j])));
                    mse[j] = (Math.pow((t[i] - y[j]), 2));
                    last_mse = mse[j];
                    // System.out.println("MSE "+t[i]+" - "+y[j]+" = "+mse[j]);
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
                        // v[k][j] = str.bobotV[k][j];
                    }
                    // update bias
                    vb[j] = vb[j] + Avb[j];
                    // System.out.println(Avb[j]+" = "+vb[j]); 
                }
            // Akhir for i
            }
        loop++;
        } while (loop < epoch && target_error < last_mse);
        System.out.println();
        System.out.println("Last MSE = "+last_mse);
        System.out.println("Epoch = "+loop);
        
        System.out.println();
        
        for (int i = 0; i < neuron_hidden; i++) {
            for (int j = 0; j < neuron_input; j++) {
//                str.bobotV[i][j] = v[i][j];
                // System.out.println("Bobot V = "+str.bobotV[i][j]);
            }
//            str.bobotVb[i] = vb[i];
            // System.out.println("Bobot Vb = "+str.bobotVb[i]);
        }
        
        System.out.println();
        
        for (int i = 0; i < neuron_output; i++) {
            for (int j = 0; j < neuron_hidden; j++) {
 //               str.bobotW[i][j] = w[i][j];
                // System.out.println("Bobot W = "+str.bobotW[i][j]);
            }
//            str.bobotWb[i] = wb[i];
            // System.out.println("Bobot Wb = "+str.bobotWb[i]);
        }
    }
}