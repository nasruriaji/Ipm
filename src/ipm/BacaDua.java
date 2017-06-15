/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author David
 */
public class BacaDua {
    public static ArrayList<String> readTeks(String bacateks) throws FileNotFoundException, IOException {
        File bacafile = new File(bacateks);
        FileReader inputDokumen = new FileReader(bacafile);
        BufferedReader bufferBaca = new BufferedReader(inputDokumen);
        StringBuffer content = new StringBuffer();
        String barisData;
        ArrayList<String> data = new ArrayList<String>();
        while ((barisData = bufferBaca.readLine()) != null) {
            content.append(barisData);
            content.append(System.getProperty("line.separator"));
            data.add(barisData);
        }
        return data;
    }
    
    public static ArrayList<String> token(String kalimat) throws FileNotFoundException, IOException {
        ArrayList<String> listKata = new ArrayList<String>();
        StringTokenizer token = new StringTokenizer(kalimat, " ");//pemisahan kata dengan delimiter spasi
        while (token.hasMoreTokens()) {
            listKata.add(token.nextToken());
        }
        return listKata;
    }
    
    public static String[][] saveToArray(ArrayList<String> input) throws FileNotFoundException, IOException{
        String[][] data=new String[input.size()][3];
        for (int i = 0; i < input.size(); i++) {
             ArrayList<String> item=token(input.get(i));
             for (int j = 0; j < item.size(); j++) {
                data[i][j]=item.get(j);//memasukkan data ke dalam array
            }
        }
        return data;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<String> listData=readTeks("d:/Output.txt");
        String[][] array=saveToArray(listData);
        
        double x[][] = new double[30][30];
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"\t");
                
                x[i][j] = Double.parseDouble(array[i][j]);
            }
            System.out.println("");
        }
        
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                System.out.println(x[i][j]);
            }
        }
    }
}
