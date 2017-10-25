/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.pruebas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ChiCuadrado {
   
    private final List<Double> numeros;

    public ChiCuadrado(List<Double> numeros) {
        this.numeros = numeros;
    }
    
    
    public void evaluar() {
        int n = 5;
        double fe = numeros.size() / (n + 0.0d);
        double intervalo = 1d / n;
        int[] fo = new int[n];
        double[] fe2 = new double[n];
        double[] fofe = new double[n];
        for (int i = 0; i < numeros.size(); i++) {
            Double aleatorio = numeros.get(i);

            for (int j = 0; j < fo.length; j++) {
                if (aleatorio <= intervalo * (j + 1)) {
                    fo[j]++;
                    break;
                }
            }

        }
        double x = 0d;
        
        System.out.print("i\t");
        System.out.print("FO\t");
        System.out.print("FE\t");
        System.out.print("(FE-FO)^2/FE\n");
        for (int i = 0; i < fo.length; i++) {
            x += ((fe - fo[i]) * (fe - fo[i])) / fe;
            fe2[i] = fe;
            fofe[i] = ((fe - fo[i]) * (fe - fo[i])) / fe;
            System.out.print(i+1);
            System.out.print("\t");
            System.out.printf("%d",fo[i]);
            System.out.print("\t");
            System.out.printf("%.1f",fe);
            System.out.print("\t");
            System.out.printf("%.5f%n",fofe[i]);
        }
        System.out.println("Valor para X0.1,4=" + x);

        System.out.println((x <= 7.77) ? "prueba con α=0.1 provienen de una distribucion uniforme"
                : "prueba con α=0.1 NO provienen de una distribucion uniforme");

    }
}
