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
public class Asset {
    double x[][] = new double[100][100];
    double v[][] = new double[100][100];
    double vb[] = {-0.3,0.3,0.3};
    double w[][] = {{0.5,-0.3,-0.4}};
    double wb[] = {-0.1};
    double t[] = new double[10];
    double lr = 0.2;
    int neuron_hidden = 3;
    int neuron_output = 1;
    int neuron_input = 2;
}
