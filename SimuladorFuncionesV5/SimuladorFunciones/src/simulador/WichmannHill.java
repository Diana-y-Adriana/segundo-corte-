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
public class WichmannHill {

    int i1_seed;
    int[] i_seed;
    //valores iniciales si no se ingresan
    static int a0 ;
    static int a1 ;
    static int a2 ;
    
    static int c0 ;
    static int c1 ;
    static int c2 ;

   

    WichmannHill(int a0, int a1, int a2, int b0, int b1, int b2, int x, int y, int z) {
        //configura los nuevos valores del generador
        this.i1_seed = x;
        i_seed = new int[2];
        i_seed[0] = y;
        i_seed[1] = z;

        this.a0 = a0;
        this.a1 = a1;
        this.a2 = a2;
        
        this.c0 = b0;
        this.c1 = b1;
        this.c2 = b2;
        
        
    }


    public double random() {

        i1_seed = i1_seed * a0 % c0;
        i_seed[0] = i_seed[0] * a1 % c1;
        i_seed[1] = i_seed[1] * a2 % c2;
        
        System.out.println("X = "+i1_seed);
        System.out.println("Y = "+i_seed[0]);
        System.out.println("Z = "+i_seed[1]);
        double value = (double) i1_seed / c0 + (double) i_seed[0] / c1 + (double) i_seed[1] / c2;
        return value - (int) value; // forza rango [0,1)
    }

   
}
