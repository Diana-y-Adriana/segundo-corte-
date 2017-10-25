package simulador;


import java.util.*;
import java.math.BigInteger;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cuadrados_Medios_1 {

    public static void main(String[] args) {
        Scanner en = new Scanner(System.in);

        JOptionPane.showMessageDialog(null, "Agrega Los Datos Necesarios Por La Consola");
        System.out.println("           Algoritmo cuadrado medios                 ");
        System.out.println("Introdusca la semilla con digito a mayor 4 nuemros");

        BigInteger n = en.nextBigInteger();

        System.out.println("Introdusca la cantidad que quiere generar X0");
        int r = en.nextInt();
        int aux = 0, digito = String.valueOf(n).length();
        for (int i = 0; i < r; i++) {
            aux = buscar(n.multiply(n).toString(), digito);
            JOptionPane.showMessageDialog(null, "0." + aux);
            n = BigInteger.valueOf(aux);
        }
    }
    private static final Logger LOG = Logger.getLogger(Cuadrados_Medios_1.class.getName());

    public static int buscar(String ca, int di) {
        int re = 0, cant = 0, pos;
        re = ca.length() / 2;
        if (di % 2 == 0) {
            cant = di / 2;
            pos = re - cant;
        } else {
            cant = di / 2 + 1;
            pos = re - cant + 1;
        }
        String aux = "";
        if (di % 2 != 0 && ca.length() % 2 == 0) {
            pos--;
        }
        for (int i = 0; i < cant; i++) {
            aux = aux + "" + ca.charAt(pos);
            pos++;
        }
        if (di % 2 != 0) {
            cant--;
        }
        for (int i = 0; i < cant; i++) {
            aux = aux + "" + ca.charAt(pos);
            pos++;
        }
        return Integer.parseInt(aux);
    }
}
