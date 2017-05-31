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
public class Learning extends javax.swing.JFrame {

    /**
     * Creates new form Learning
     */
    public Learning() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hidden Layer");

        jLabel2.setText("Learning Rate");

        jLabel3.setText("Epoch");

        jLabel4.setText("Target Error");

        jButton1.setText("Latih");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double x[][] = {{1,1}};
        double v[][] = {{0.2,0.3,-0.1},{0.3,0.1,-0.1}};
        double vb[] = {-0.3,0.3,0.3};
        double w[][] = {{0.5,-0.3,-0.4}};
        double wb[] = {-0.1};
        double t[] = {0};
        double lr = Double.parseDouble(jTextField2.getText());
        double mse[] = new double[10];
        int neuron_hidden = Integer.parseInt(jTextField1.getText());
        int neuron_output = 1;
        int neuron_input = 2;
        int loop = 0;
        int epoch = Integer.parseInt(jTextField3.getText());
        double target_error = Double.parseDouble(jTextField4.getText());
        double last_mse = 0;
        
        
        
        do {
            for (int i = 0; i < 1; i++) {

                // Hitung hidden layer
                double z[] = new double[10];
                for (int j = 0; j < 3; j++) {
                    double z_net[] = new double[10];
                    double temp = 0;
                    for (int k = 0; k < 2; k++) {
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
                        temp = temp + (z[k] * w[j][k]);
                    }

                    // Hasil y_net + bias
                    y_net[j] = wb[j] + temp;
                    // System.out.println("y_net = "+y_net[j]);

                    // Hasil y dengan aktivasi sigmoid biner
                    y[j] = 1/(1+(Math.exp(-y_net[j])));
                    // System.out.println("y = "+y[j]);
                    
                    // MSE
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
        // System.out.println("Last MSE = "+last_mse);
        // System.out.println("Epoch = "+loop);
        jTextArea1.setText("MSE = "+last_mse+"\n Epoch ke"+loop);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Learning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Learning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Learning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Learning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Learning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
