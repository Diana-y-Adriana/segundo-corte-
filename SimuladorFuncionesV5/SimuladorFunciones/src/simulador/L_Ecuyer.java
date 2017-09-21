/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

/**
 *
 * @author Administrator
 */
public class L_Ecuyer {
    
     int X;
     int Y;
     int Z;
    static  int c0 = 40014;
    static  int c1 = 40692;
    private int m3;
    private  int m2;
    private  int m1;

    public L_Ecuyer(int a1, int a2, int m1, int m2, int m3, int x, int y) {
        //configura los valores ingresados para el generador
        this.X = x;
        this.Y = y;
        
        this.c0 = a1;
        this.c1 = a2;
        
        this.m3 = m3;
        this.m2 = m2;
        this.m1 = m1;
    }


    

    public double random() {

      
        
        
        X = X * c0 % m1;
        Y = Y * c1 % m2;
         //z para los valores iniciales
        Z = Math.abs(X-Y) % m3;
        System.out.println("X = "+X);
        System.out.println("Y = "+Y);
        System.out.println("Z = "+Z);
        double value = 0.0;
        if (Z>=0) {
            value = (double)Z/2147483563;
            
        }
        if (Z==0) {
            value = 2147483562/2147483563;
        }
        return value- (int) value;
        
    }

}
