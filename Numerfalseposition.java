/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.Scanner;

public class Numerfalseposition {
    public static double f(double x, int n, int xToFindRoot) {
        return Math.pow(x, n) - xToFindRoot;
    }

    public static double falseposition(double a, double b, double epsilon, int n, int xToFindRoot) {
        double Oldx = 0;
        double x;

        while (true) {
            x = (a * f(b, n, xToFindRoot) - b * f(a, n, xToFindRoot)) / (f(b, n, xToFindRoot) - f(a, n, xToFindRoot));

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
        Scanner input = new Scanner(System.in);
        int xToFindRoot = input.nextInt();
        int n = input.nextInt();
        double a = input.nextDouble();
        double b = input.nextDouble();
        double epsilon = 1e-6;

        double approxRoot = falseposition(a, b, epsilon, n, xToFindRoot);
        System.out.printf("%.4f\n", approxRoot);
    }
}
