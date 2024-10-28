/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package numerical;

public class MultipleLinearRegression {
    public static void main(String[] args) {
        double[][] x = {
            {1, 0, 1},
            {0, 1, 3},
            {2, 4, 1},
            {3, 2, 2},
            {4, 1, 5},
            {2, 3, 3},
            {1, 6, 4}
        };
        double[] y = {4, -5, -6, 0, -1, -7, -20};

        // Construct augmented matrix
        double[][] augmentedMatrix = new double[x.length][4];
        for (int i = 0; i < x.length; i++) {
            augmentedMatrix[i][0] = 1;
            for (int j = 0; j < x[i].length; j++) {
                augmentedMatrix[i][j + 1] = x[i][j];
            }
        }

        double[][] normalMatrix = new double[4][4];
        double[] targetVector = new double[4];

        // Build the normal matrix
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                normalMatrix[i][j] = 0;
                for (int k = 0; k < x.length; k++) {
                    normalMatrix[i][j] += augmentedMatrix[k][i] * augmentedMatrix[k][j];
                }
            }
            targetVector[i] = 0;
            for (int k = 0; k < x.length; k++) {
                targetVector[i] += augmentedMatrix[k][i] * y[k];
            }
        }

        // Solve using Gaussian elimination
        double[] coefficients = gaussianElimination(normalMatrix, targetVector);
        System.out.println("Multiple Linear Regression Equation: f(x) = " +
                coefficients[0] + " + " + coefficients[1] + " * x1 + " +
                coefficients[2] + " * x2 + " + coefficients[3] + " * x3");
    }

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
