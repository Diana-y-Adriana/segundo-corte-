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
public class Promedios {
   

    List<Double> aleatorios;
    
    public Promedios(List<Double> aleatorios) {
        this.aleatorios = aleatorios;
    }

    public boolean evaluar() {
        double sumatoria=0d;
        double N = aleatorios.size();
        for (int i = 0; i < aleatorios.size(); i++) {
            Double aleatorio = aleatorios.get(i);
            sumatoria +=aleatorio;
        }
        
        double x = sumatoria/N;
        System.out.println("Promedio = "+x);
        double z0 = ((x-(1d/2d))*Math.sqrt(N))/(Math.sqrt(1d/12));
	System.out.println("Zo = "+z0);
	System.out.println("Za = "+1.96);
        z0 = Math.abs(z0);
        double alfa = 0.05d;
        
        double zalfa = 1.96;
	
        
        return z0 < zalfa;
        
    }
    
    
    
    
}
