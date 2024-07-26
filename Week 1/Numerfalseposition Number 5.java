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

    public static double falseposition(double a, double b, double tolerance, int n, int xToFindRoot) {
        double Oldx = 0;
        double x;

        while (true) {
            x = (a * f(b, n, xToFindRoot) - b * f(a, n, xToFindRoot)) / (f(b, n, xToFindRoot) - f(a, n, xToFindRoot));

            if (f(x, n, xToFindRoot) == 0 || (Math.abs(x - Oldx)/Math.abs(x))*100 < tolerance) {
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
        double tolerance = 1e-100;

        double approxRoot = falseposition(a, b, tolerance, n, xToFindRoot);
        System.out.printf("%.6f\n", approxRoot);
    }
    
}
