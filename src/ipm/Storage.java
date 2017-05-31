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
public class Storage {
    public double dataLatih[][] = new double[50][50];
    public double dataUji[][] = new double[50][50];
    public double bobotW[][] = new double[100][100];
    public double bobotWb[] = new double[100];
    public double bobotV[][] = new double[100][100];
    public double bobotVb[] = new double[100];
    public double target[] = new double[50];
    
    public double nilaiMax(double[][] arr, int n) {
        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                if (max < arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
    
    public double nilaiMin(double[][] arr, int n) {
        double min = 100;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {                
                if (min > arr[i][j]){
                    min = arr[i][j];
                }
            }
        }
        return min;
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
            System.out.println("SQL Gagal : "+e);
        }
        return count;
    }
}
