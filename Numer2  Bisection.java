/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author USER
 */
public class Numer2 {
    public static double f(double x, int n, int xToFindRoot) {
        return Math.pow(x, n) - xToFindRoot;
    }

    public static double bisection(double a, double b, double epsilon, int n, int xToFindRoot) {
        double Oldm = 0;
        double m;

        while (true) {
            m = (a + b) / 2;

            if (f(m, n, xToFindRoot) == 0 || Math.abs(m - Oldm) < epsilon) {
                break;
            }
            
            else if (f(m, n, xToFindRoot) * f(a, n, xToFindRoot) < 0) {
                b = m;
            } else {
                a = m;
            }
            Oldm = m;
        }

        return m;
    }

    public static void main(String[] args) {
        double a = 1.5; 
        double b = 2.0;
        double epsilon = 1e-6; // epsilon value
        int n = 4;
        int xToFindRoot = 13;

        double approxRoot = bisection(a, b, epsilon, n, xToFindRoot);
        System.out.printf("Answer is: %.6f\n", approxRoot);
    }
}

