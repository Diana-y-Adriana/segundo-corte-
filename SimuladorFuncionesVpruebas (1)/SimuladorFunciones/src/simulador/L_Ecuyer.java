/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Administrator
 */
public class L_Ecuyer {

    public static void main(String[] args) {

        int a1 = (int) 3;
        int a2 = (int) 5;
        int m1 = (int) 5;
        int m2 = (int) 7;
        int m3 = (int) 7;
        int x = 1;
        int y = 3;
       
        System.out.println("whiy =  "+Integer.MAX_VALUE*40014);
        for (int i = 0; i <= 15; i++) {
            L_Ecuyer ecuyer = new L_Ecuyer(a1, a2, m1, m2, m3, x, y, i);
            double aleatorio = ecuyer.random();

            System.out.println(aleatorio);
        }
    }

    double X;
    double Y;
    double Z;
    static double c0 = 40014;
    static double c1 = 40692;
    private double m3;
    private double m2;
    private double m1;
    private final int n;
    private final double X0;
    private final double Y0;

    public L_Ecuyer(double a1, double a2, double m1, double m2, double m3, double x, double y, int i) {
        //configura los valores ingresados para el generador
        this.X0 = x;
        this.Y0 = y;
        this.X = x;
        this.Y = y;
        this.n = i;

        this.c0 = a1;
        this.c1 = a2;

        this.m3 = m3;
        this.m2 = m2;
        this.m1 = m1;
    }

    public double random() {

        //System.out.println("X:");
       
        if (n!=0) {
            
          
            
            //X = (c0 * getX(n - 1, c0, X0, m1)) % m1;    
            X = getX(n, c0, X0, m1);    
            //Y = (c1 * getX(n - 1, c1, Y0, m2)) % m2;    
            Y = getX(n, c1, Y0, m2);    
        }
        
        //z para los valores iniciales
        
          Z =(X - Y) % m3;
          
        if (X>Y) {
             Z =(X - Y) % m3;
        }
        else
        {
         Z =((X - Y) % m3)+m3;
        }
       
        
        
//        System.out.println("X = " + X);
//        System.out.println("Y = " + Y);
//        System.out.println("Z = " + Z);
        double U = 0.0;
        if (Z > 0) {
            U = (double) Z / m1;

        }else {
            U = m3 / m1;
        }
        return U;

    }

    double getX(int n, double a, double x, double m) {
        if (n <= 0) {
            return x;
        } else {
            // System.out.println(n);
           // BigInteger temp = new BigInteger(a+"");
            //temp = temp.multiply(new BigInteger((getX(n - 1, a, x, m))+""));
            return  (a * getX(n - 1, a, x, m)) % m;
            //temp = temp.mod(new BigInteger(m+""));
            //return temp.intValue();
        }
    }

}
