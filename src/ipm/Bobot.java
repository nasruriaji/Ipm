/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author David
 */
public class Bobot {
    public void writeTwoD(double a[][]){
        String teks = "";
        String path = "d:/output.txt";
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                teks = (teks+" ") + Double.toString(a[i][j]);
            }
        }
        
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(teks);
            bw.close();
        } catch (Exception e) {
        }
    }
    
    public double[][] readTwoD(){
        Scanner scan;
        File file = new File("d:/output.txt");
        
        double arr[] = new double[10];
        double x[][] = new double[10][10];
        int i = 0;
        
        try {
            scan = new Scanner(file);

            while(scan.hasNextDouble())
            {
                arr[i] = scan.nextDouble();
                i++;
            }
        
            int count = 0;
            
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (count == 6) break;
                    x[j][k] = arr[count];
                    count++;
                }
            }
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        
        return x;
    }
    
    public void writeOneD(double a[]){
        String teks = "";
        String path = "d:/output.txt";
        
        for (int i = 0; i < 6; i++) {
            teks = (teks+" ") + Double.toString(a[i]);
        }
        
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(teks);
            bw.close();
        } catch (Exception e) {
        }
    }
    
    public double[] readOneD(){
        Scanner scan;
        File file = new File("d:/output.txt");
        
        double arr[] = new double[10];
        int i = 0;
        
        try {
            scan = new Scanner(file);

            while(scan.hasNextDouble())
            {
                arr[i] = scan.nextDouble();
                i++;
            }
        } catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
        
        return arr;
    }
    
    public static void main(String[] args) {
        Bobot b = new Bobot();
        
        // double arr[][] = {{1,2,5},{3,4,6}};
        double brr[] = {7,8,9,4,10,11};
        
        // b.writeTwoD(arr);
        // double a[][] = b.readTwoD();
//        
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println(a[i][j]);
//            }
//        }
//        
        b.writeOneD(brr);
        double c[] = b.readOneD();
        
        for (int i = 0; i < 6; i++) {
            System.out.println(c[i]);
        }
    }
}
