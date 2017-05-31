/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class Data extends javax.swing.JFrame {

    /**
     * Creates new form Data
     */
    
    private DefaultTableModel tbDataIpm;
    
    public Data() {
        initComponents();
        
        setTitle("Data IPM");
        
        tbDataIpm = new DefaultTableModel();
        
        tabelDataIpm.setModel(tbDataIpm);
        tbDataIpm.addColumn("ID Data");
        tbDataIpm.addColumn("Tahun");
        tbDataIpm.addColumn("T5");
        tbDataIpm.addColumn("T4");
        tbDataIpm.addColumn("T3");
        tbDataIpm.addColumn("T2");
        tbDataIpm.addColumn("T1");
        tbDataIpm.addColumn("T");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textTahun = new javax.swing.JTextField();
        textT5 = new javax.swing.JTextField();
        textT4 = new javax.swing.JTextField();
        textT3 = new javax.swing.JTextField();
        textT2 = new javax.swing.JTextField();
        textT1 = new javax.swing.JTextField();
        textT = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataIpm = new javax.swing.JTable();
        buttonSimpan = new javax.swing.JButton();
        buttonTampil = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tahun");

        jLabel2.setText("T5");

        jLabel3.setText("T4");

        jLabel4.setText("T3");

        jLabel5.setText("T2");

        jLabel6.setText("T1");

        jLabel7.setText("T");

        textTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTahunActionPerformed(evt);
            }
        });

        textT5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textT5ActionPerformed(evt);
            }
        });

        textT4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textT4ActionPerformed(evt);
            }
        });

        tabelDataIpm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelDataIpm);

        buttonSimpan.setText("Simpan");
        buttonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanActionPerformed(evt);
            }
        });

        buttonTampil.setText("Tampil");
        buttonTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTampilActionPerformed(evt);
            }
        });

        jButton1.setText("Ubah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textT)
                            .addComponent(textT2)
                            .addComponent(textT3)
                            .addComponent(textT4)
                            .addComponent(textTahun)
                            .addComponent(textT1)
                            .addComponent(textT5))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonTampil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(textTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2))
                                    .addComponent(textT5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textT4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(textT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5))
                            .addComponent(textT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(textT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSimpan)
                            .addComponent(buttonTampil))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTahunActionPerformed

    private void buttonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanActionPerformed
        int tahun = Integer.parseInt(textTahun.getText());
        double t5 = Double.parseDouble(textT5.getText());
        double t4 = Double.parseDouble(textT4.getText());
        double t3 = Double.parseDouble(textT3.getText());
        double t2 = Double.parseDouble(textT2.getText());
        double t1 = Double.parseDouble(textT1.getText());
        double t = Double.parseDouble(textT.getText());
        int id = 0;
        
        try {
            Statement stm;
            stm = Koneksi.getConn().createStatement();
            stm.executeUpdate("insert into data_ipm values('"+id+"','"+
                    tahun+"','"+t5+"','"+t4+"','"+t3+"','"+t2+"','"+t1+"',"+t+")");
            stm.close();
            JOptionPane.showMessageDialog(rootPane, "Data Disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Disimpan\n"+e.toString());
        }
    }//GEN-LAST:event_buttonSimpanActionPerformed

    private void textT5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textT5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textT5ActionPerformed

    private void textT4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textT4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textT4ActionPerformed

    private void buttonTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTampilActionPerformed
        tbDataIpm.getDataVector().removeAllElements();
        tbDataIpm.fireTableDataChanged();
        
        try {
            Statement stm = Koneksi.getConn().createStatement();
            ResultSet rsl = stm.executeQuery("select * from data_ipm");
            
            while (rsl.next()) {
                Object[] obj = new Object[8];
                
                obj[0] = rsl.getString("id_data_ipm");
                obj[1] = rsl.getString("tahun_data_ipm");
                obj[2] = rsl.getString("t5");
                obj[3] = rsl.getString("t4");
                obj[4] = rsl.getString("t3");
                obj[5] = rsl.getString("t2");
                obj[6] = rsl.getString("t1");
                obj[7] = rsl.getString("t");
                
                tbDataIpm.addRow(obj);
            }
            
            rsl.close();
            stm.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Data\n"+e.toString());
        }
    }//GEN-LAST:event_buttonTampilActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String id_ipm = String.valueOf(tabelDataIpm.getValueAt(tabelDataIpm.getSelectedRow(), 0));
        
        try {
            Statement stm;
            stm = Koneksi.getConn().createStatement();
            stm.executeUpdate("delete from data_ipm where id_data_ipm = '"+id_ipm+"'");
            stm.close();
            JOptionPane.showMessageDialog(rootPane, "Data Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal Dihapus\n"+e.toString());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*
        int id = 15;
        double tahun = Integer.parseInt(textTahun.getText());
        double t5 = Double.parseDouble(textT5.getText());
        double t4 = Double.parseDouble(textT4.getText());
        double t3 = Double.parseDouble(textT3.getText());
        double t2 = Double.parseDouble(textT2.getText());
        double t1 = Double.parseDouble(textT1.getText());
        double t = Double.parseDouble(textT.getText());
        
        try {
            Statement stm;
            stm = Koneksi.getConn().createStatement();
            stm.executeUpdate("update data_ipm set tahun_data_ipm = '"+
                    tahun+"',t5 = '"+t5+"',t4 = "+t4+",t3 = "+
                    t3+",t2 = '"+t2+"',t1 = "+t1+" where id_ipm = '"+id+"'");
            
            Object[] obj = new Object[7];
            
            obj[0]=id.getText();
            obj[1]=txtJenis.getText();
            obj[2]=txtWarna.getText();
            obj[3]=txtBeli.getText();
            obj[4]=txtJual.getText();
            obj[5]=cmbLingkungan.getSelectedItem();
            obj[6]=txtStok.getText();
            
            tblIkan.removeRow(row);
            tblIkan.insertRow(row, obj);
            
            stm.close();
            JOptionPane.showMessageDialog(rootPane, "Data Diedit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal Diedit\n"+e.toString());
        }
        */
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
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSimpan;
    private javax.swing.JButton buttonTampil;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelDataIpm;
    private javax.swing.JTextField textT;
    private javax.swing.JTextField textT1;
    private javax.swing.JTextField textT2;
    private javax.swing.JTextField textT3;
    private javax.swing.JTextField textT4;
    private javax.swing.JTextField textT5;
    private javax.swing.JTextField textTahun;
    // End of variables declaration//GEN-END:variables
}
