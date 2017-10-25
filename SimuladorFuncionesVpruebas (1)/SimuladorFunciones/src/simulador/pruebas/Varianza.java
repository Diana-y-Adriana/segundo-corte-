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
public class Varianza {


    List<Double> aleatorios;

    public Varianza(List<Double> aleatorios) {
	this.aleatorios = aleatorios;
    }

    public boolean evaluar() {
	double sumatoria = 0d;
	double N = aleatorios.size();

	for (int i = 0; i < aleatorios.size(); i++) {
	    Double aleatorio = aleatorios.get(i);
	    sumatoria += aleatorio;
	}

	double promedio = sumatoria / N;
	System.out.println("promedio = " + promedio);
	sumatoria = 0.0;
	for (int i = 0; i < aleatorios.size(); i++) {
	    Double aleatorio = aleatorios.get(i);
	    sumatoria += Math.pow(aleatorio - promedio, 2);
	}
	double Vr = sumatoria / (N - 1);

	double alfa = 5d / 100;
	double LI = (alfa / 2d);
	double LS = 1 - (alfa / 2d);

	System.out.println("varianza = " + Vr);
	System.out.println("\nLI = X^2  " + LI + "," + (N - 1) + " / " + (12 * (N - 1)));
	LI = Tabla_chi_cuadrado.retornarXn((int) N - 1, LI) / (12 * (N - 1));
	System.out.println("LI =   " + LI);

	System.out.println("\nLS = X^2  " + LS + "," + (N - 1) + " / " + (12 * (N - 1)));
	LS = Tabla_chi_cuadrado.retornarXn((int) N - 1, LS) / (12 * (N - 1));
	System.out.println("LS = X^2  " + LS);

	

	//determina el mayor y el menor para la comparacion final
	double i1 = Math.max(LS, LI);
	double i2 = Math.min(LS, LI);
	LS = i1;
	LI = i2;
	
	System.out.print("\nDado que V(r) = " + Vr);
	if (Vr < LS && Vr > LI) {
	    System.out.println(" esta entre los limites de aceptación, \nno se puede rechazar el conjunto de numero.");
	} else {
	    System.out.println(" NO esta entre los limites de aceptación, \nse puede rechazar el conjunto de numero.");
	}

	return (Vr < LS && Vr > LI);
    }

}
