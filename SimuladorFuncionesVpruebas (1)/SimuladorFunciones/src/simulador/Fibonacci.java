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
class Fibonacci {
    public static void main(String[] args) {
        int n=5;
        int n0=4;
        int n1=11;
        int m= 13;
        int s= 1;
        int r= 2;
        int operacion = 3;
        for (int i = 0; i < 9; i++) {
            n=i;
            System.out.println(Fibonacci.fib(n,n0,n1, m,s,r,operacion));
        }
        
    }
    public static int fib(int n,int n0,int n1,int m,int s,int r,int operacion) {
        if (n==0) {
            return n0;
        }
        if (n==1) {
            return n1;
        }
        int Nn;
           switch (operacion) {
            case 1://suma
                Nn = (fib(n-s,n0,n1,m,s,r,operacion) + fib(n-r,n0,n1,m,s,r,operacion)) % m;
                break;
            case 2://resta

                Nn = (fib(n-s,n0,n1,m,s,r,operacion) - fib(n-r,n0,n1,m,s,r,operacion)) % m;
                break;
            case 3://multiplicacion
                Nn = (fib(n-s,n0,n1,m,s,r,operacion) * fib(n-r,n0,n1,m,s,r,operacion)) % m;
                break;

            default:
                throw new AssertionError();
        }
           //System.out.println(Nn);
        return Nn;
        
    }
}
