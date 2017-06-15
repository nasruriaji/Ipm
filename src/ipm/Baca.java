/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import  java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Baca {
    public void tulis(){
        FileOutputStream foutput = null;
        String data = "Halo lagi";
        
        // membuka file
        
        try {
            foutput = new FileOutputStream("d:/Output.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
        
        try {
            for (int i = 0; i < data.length(); i++) {
                foutput.write((int) data.charAt(i));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        
        try {
            foutput.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void bacalah(){
        FileOutputStream finput = null;
        int data;
        
        try {
            finput = new FileOutputStream("d:/Output.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
        
//        try {
//            while ((data = finput.read())!=-1)
//            {
//                System.out.println((char)data);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
        
        try {
            finput.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void tulisen(double a[][]){
        String teks = "";
        String path = "d:/output.txt";
        
        // StringBuffer content = new StringBuffer();
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                teks = (teks+" ") + Double.toString(a[i][j]);
            }
            // teks = teks+content.append(System.getProperty("line.separator"));
        }
        
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(teks);
            bw.close();
        } catch (Exception e) {
        }
    }
    
    public void bacaen(){
        String lokasi_file = "d:/output.txt";
        
        try {
            FileReader fr = new FileReader(lokasi_file);
            BufferedReader br = new BufferedReader(fr);
            
            String text;
            
            while ((text = br.readLine()) != null)
                System.out.println(text);
        } 
        catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        } 
        catch (IOException ioe) {
            ioe.getMessage();
        }
    }
    
    public void woco(){
        Scanner scan;
        File file = new File("d:/output.txt");
        
        double arr[] = new double[10];
        double x[][] = new double[10][10];
        int i = 0;
        
        try {
            scan = new Scanner(file);

            while(scan.hasNextDouble())
            {
                // System.out.println( scan.nextDouble() );
                arr[i] = scan.nextDouble();
                i++;
            }
            
            for (int j = 0; j < 6; j++) {
                // System.out.println(arr[j]);
            }
        
            int count = 0;
            
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (count == 6) break;
                    x[j][k] = arr[count];
                    count++;
                    // System.out.println(arr[count]);
                    System.out.println(j+" "+k+" = "+x[j][k]);
                }
            }
            
            System.out.println(count);
            
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        // Baca a = new Baca();
        
        // double arr[][] = {{1,2,5},{3,4,6}};
        
        // a.tulis();
        // a.bacalah();
        // a.tulisen(arr);
        // a.bacaen();
        // a.woco();
        
//        double y = 0;
        double t[] = {1,0};
//        double mse[] = new double[10];
        double rekap = 0;
        int n = 2;
        int epoch = 2;
        // double y[] = {5,4,3,2,1};
        
        for (int i = 0; i < epoch; i++) {
            double temp_mse[] = new double[5];
            double mse = 0;
            
            for (int j = 0; j < n; j++) {
                double y[] = new double[1];
                for (int k = 0; k < 1; k++) {
                    y[k] = 2;
                    temp_mse[j] = Math.pow((y[k]-t[j]), 2)/n;
                }
                mse = mse + temp_mse[j];
            }
            System.out.println(mse);
        }
        
        System.out.println();
        
        for (int h = 0; h < epoch; h++) {
            double temp_mse[] = new double[5];
            double mse = 0;
            
            for (int i = 0; i < n; i++) {
                double y[] = new double[1];
                for (int j = 0; j < 1; j++) {
                    for (int k = 0; k < 3; k++) {
                        
                    }
                    y[j] = 2;
                    temp_mse[i] = Math.pow((y[j]-t[i]), 2)/n;
                }
                mse = mse + temp_mse[i];
            }
            System.out.println(mse);
        }
    }
}
