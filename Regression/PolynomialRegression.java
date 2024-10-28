/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numerical;

public class PolynomialRegression {
    public static void main(String[] args) {
        double[] x = {10, 15, 20, 30, 40, 50, 60, 70, 80};
        double[] y = {5, 9, 15, 18, 22, 30, 35, 38, 43};
        int n = x.length;

        // Calculate sums
        double sumX = 0, sumX2 = 0, sumX3 = 0, sumX4 = 0;
        double sumY = 0, sumXY = 0, sumX2Y = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumX2 += x[i] * x[i];
            sumX3 += x[i] * x[i] * x[i];
            sumX4 += x[i] * x[i] * x[i] * x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2Y += x[i] * x[i] * y[i];
        }

        // Solving the 3x3 system
        double[][] A = {
            {n, sumX, sumX2},
            {sumX, sumX2, sumX3},
            {sumX2, sumX3, sumX4}
        };
        double[] B = {sumY, sumXY, sumX2Y};
        double[] coefficients = gaussianElimination(A, B);

        System.out.println("Polynomial Regression Equation: f(x) = " +
                coefficients[0] + " + " + coefficients[1] + " * x + " + coefficients[2] + " * x^2");
    }

    // Gaussian elimination method
    public static double[] gaussianElimination(double[][] A, double[] B) {
        int n = B.length;
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(A[j][i]) > Math.abs(A[max][i])) max = j;
            }
            double[] temp = A[i]; A[i] = A[max]; A[max] = temp;
            double t = B[i]; B[i] = B[max]; B[max] = t;

            for (int j = i + 1; j < n; j++) {
                double factor = A[j][i] / A[i][i];
                B[j] -= factor * B[i];
                for (int k = i; k < n; k++) A[j][k] -= factor * A[i][k];
            }
        }
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) sum += A[i][j] * x[j];
            x[i] = (B[i] - sum) / A[i][i];
        }
        return x;
    }
}
