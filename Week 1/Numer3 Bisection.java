/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.Scanner;

public class Numer3 {
    public static double f(double x, int n, int xToFindRoot) {
        return Math.pow(x, n) - xToFindRoot;
    }

    public static double bisection(double a, double b, double tolerance, int n, int xToFindRoot) {
        double Oldm = 0;
        double m;

        while (true) {
            m = (a + b) / 2;

            if (f(m, n, xToFindRoot) == 0 || (Math.abs(m - Oldm)/Math.abs(m))*100 < tolerance) {
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
        Scanner input = new Scanner(System.in);
        int xToFindRoot = input.nextInt();
        int n = input.nextInt();
        double a = input.nextDouble();
        double b = input.nextDouble();
        double tolerance = 1e-6;

        double approxRoot = bisection(a, b, tolerance, n, xToFindRoot);
        System.out.printf("%.6f\n", approxRoot);
    }
}

