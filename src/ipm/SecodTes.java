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
public class SecodTes {
    public double NilaiMaximum(double[][] arr) {
        double max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
    
    public double NilaiMinimum(double[][] arr) {
        double min = 100;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 6; j++) {                
                if (min > arr[i][j]){
                    min = arr[i][j];
                }
            }
        }
        return min;
    }
    
    public double normalisasi(double[][] arr) {
        double normal = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 6; j++) {
                normal = ((0.8 * (arr[i][j] - NilaiMinimum(arr)))/(NilaiMaximum(arr)-NilaiMinimum(arr)))+0.1;
            }
        }
        return normal;
    }
    
    public int countRecords() {
        int count = 0;
        try {
            Statement stm = Koneksi.getConn().createStatement();
            ResultSet rsl = stm.executeQuery("select count(*) from data_ipm");
            
            while (rsl.next()) {
                count = rsl.getInt(1);
            }
            rsl.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Gagal"+e);
        }
        return count;
    }
    
    public static void main(String[] args) {
        double x[][] = new double[50][50];
        int i = 0;
        
        try {
            Statement stm = Koneksi.getConn().createStatement();
            ResultSet rsl = stm.executeQuery("select count(*) from data_ipm");
            
            while (rsl.next()) {
                // System.out.println(rsl.getInt(1));
            }
            rsl.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Gagal"+e);
        }
        
        try {
            Statement stm = Koneksi.getConn().createStatement();
            ResultSet rsl = stm.executeQuery("select * from data_ipm");
            
            while (rsl.next()) {
                x[i][0] = rsl.getDouble("t5");
                x[i][1] = rsl.getDouble("t4");
                x[i][2] = rsl.getDouble("t3");
                x[i][3] = rsl.getDouble("t2");
                x[i][4] = rsl.getDouble("t1");
                x[i][5] = rsl.getDouble("t");
                i++;
            }
        
            rsl.close();
            stm.close();
        } catch (SQLException e) {
            System.out.println("Gagal"+e);
        }
        
        SecodTes st = new SecodTes();
        double norm = 0;
        double xnorm[][] = new double[50][50];
        
        for (int j = 0; j < x.length; j++) {
            for (int k = 0; k < x.length; k++) {
                // System.out.println("["+j+"]["+k+"] = "+x[j][k]);
                // System.out.println("Normalisasi = "+st.normalisasi(x));
                // norm = ((0.8 * (x[0][0] - st.NilaiMinimum(x)))/(st.NilaiMaximum(x)-st.NilaiMinimum(x)))+0.1;;
                xnorm[j][k] = st.normalisasi(x);
            }
            // System.out.println();
        }
        
        // System.out.println("Norm = "+norm);
        
        // System.out.println("Jumlah Data = "+st.countRecords());
        System.out.println();
        // System.out.println("Max = "+st.NilaiMaximum(x));
        // System.out.println("Min = "+st.NilaiMinimum(x));
        
        double w[][] = new double[10][10];
        double wb[] = new double[10];
        
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 2; k++) {
                w[i][j] = Math.random();
                // System.out.println(w[i][j]);
            }
        }
    }
}
