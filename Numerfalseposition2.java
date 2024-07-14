/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
/**
 *
 * @author USER
 */

public class Numerfalseposition2 {
public static double f(double x, int n, int xToFindRoot) {
        return Math.pow(x, n) - xToFindRoot;
    }

    public static double falseposition(double a, double b, double epsilon, int n, int xToFindRoot) {
        double Oldx = 0;
        double x;
        int i = 1;

        while (true) {
            x = (a * f(b, n, xToFindRoot) - b * f(a, n, xToFindRoot)) / (f(b, n, xToFindRoot) - f(a, n, xToFindRoot));
            System.out.println("i : "+ i++);
            System.out.println("A : "+ a);
            System.out.println("f(a) : "+ f(a, n, xToFindRoot));
            System.out.println("B : "+ b);
            System.out.println("f(b) : "+ f(b, n, xToFindRoot));
            System.out.println("X : "+ x);
            System.out.println("F(x)*F(A) : "+ f(x, n, xToFindRoot) * f(a, n, xToFindRoot));
            System.out.println("Eabs : "+ Math.abs(x - Oldx));
            System.out.println("-----------------------------------------------------------");

            if (f(x, n, xToFindRoot) == 0 || Math.abs(x - Oldx) < epsilon) {
                break;
            }

            else if (f(x, n, xToFindRoot) * f(a, n, xToFindRoot) < 0) {
                b = x;
            } else {
                a = x;
            }
            Oldx = x;
            
        }

        return x;
    }

    public static void main(String[] args) {
        int xToFindRoot = 13;
        int n = 4;
        double a = 1.5;
        double b = 2;
        double epsilon = 1e-100;

        double approxRoot = falseposition(a, b, epsilon, n, xToFindRoot);
        System.out.printf("%.6f\n", approxRoot);
    }
    
}
