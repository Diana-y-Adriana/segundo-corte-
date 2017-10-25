/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador.pruebas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class KolmogorovPrueba {
      
    
    

    private List<Double> aleatorios4;
    private double matrizFrecuencia[][];
    private boolean pasaPrueba;
    private float finalAlfa;
    private int iAlfa = 0;

    public float getFinalAlfa() {
        return finalAlfa;
    }

    public void setFinalAlfa(float finalAlfa) {
        this.finalAlfa = finalAlfa;
    }

    public boolean isPasaPrueba() {
        return pasaPrueba;
    }

    public void setPasaPrueba(boolean pasaPrueba) {
        this.pasaPrueba = pasaPrueba;
    }

    public double[][] getMatrizFrecuencia() {
        return matrizFrecuencia;
    }

    public void setMatrizFrecuencia(double[][] matrizFrecuencia) {
        this.matrizFrecuencia = matrizFrecuencia;
    }

    public int getiAlfa() {
        return iAlfa;
    }

    public void setiAlfa(int iAlfa) {
        this.iAlfa = iAlfa;
    }

    public KolmogorovPrueba(List<Double> aleatorio) {

        int pasadas = 0;
        int comparaciones = 0;
        boolean hayCambios = true;
        for (int i = 0; hayCambios; i++) {
            ++pasadas;
            hayCambios = false;
            for (int j = 0; j < aleatorio.size() - 1; j++) {
                ++comparaciones;
                if (aleatorio.get(j) > aleatorio.get(j + 1)) {
                    intercambiar(aleatorio, j, j + 1);
                    hayCambios = true;
                }
            }
        }
        this.aleatorios4 = aleatorio;
    }

    private static void intercambiar(List<Double>  arreglo, int a, int b) {
        double tmp = arreglo.get(a);
	arreglo.set(a, arreglo.get(b));
	arreglo.set(b, tmp);
    }

    public void calcularFn() {
        //3. Calcular Fn(xi) = i/N
        int tam = aleatorios4.size();
        double Fn;
        double diferencia;

        matrizFrecuencia = new double[tam][3];
        for (int i = 0; i < matrizFrecuencia.length; i++) {
            matrizFrecuencia[i][0] = aleatorios4.get(i); //Xi

            Fn = (double) (i + 1.0) / tam;
            matrizFrecuencia[i][1] = (double) Math.rint(Fn * 10000) / 10000;
            diferencia = matrizFrecuencia[i][0] - (double) ((i + 1.0) / tam);

            matrizFrecuencia[i][2] = (float) Math.abs(Math.rint(diferencia * 10000) / 10000);
        }


    }

    public double calcularDn() {
        //4. Calcular Dn
        //Seleccionar el máximo 
        double max = matrizFrecuencia[0][2];
        for (int i = 1; i < matrizFrecuencia.length; i++) {
            if (matrizFrecuencia[i][2] > max) {
                max = matrizFrecuencia[i][2];
            }
        }


        switch (iAlfa) {
            case 10:

                finalAlfa = (float) (((1.22)) / (Math.sqrt(aleatorios4.size())));
                //System.out.println("10 %=> " + finalAlfa);
                break;
            case 5:

                finalAlfa = (float) (((1.36)) / (Math.sqrt(aleatorios4.size())));
                //System.out.println("5 %=> " + finalAlfa);
                break;
            case 1:

                finalAlfa = (float) (((1.63)) / (Math.sqrt(aleatorios4.size())));
                //System.out.println("1 % => " + finalAlfa);
                break;
            default:
                finalAlfa = (float) 0.0;
                break;
        }

        if (max < finalAlfa) {
            pasaPrueba = true;
        } else {
            pasaPrueba = false;
        }
        return max;
    }
}
