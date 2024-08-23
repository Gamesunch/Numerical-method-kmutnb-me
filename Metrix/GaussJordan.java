package com.mycompany.metrixmaven;

import org.ejml.simple.SimpleMatrix;

public class GaussJordan {
    public static void main(String[] args) {
        double[][] A = {
            {-2, 3, 1, 9},
            {3, 4, -5, 0},
            {1, -2, 1, -4}
        };

        SimpleMatrix matrix = new SimpleMatrix(A);
        int rows = matrix.numRows();
        int cols = matrix.numCols();

        // Gauss-Jordan Elimination
        for (int i = 0; i < rows; i++) {
            // Normalize the pivot row
            double pivot = matrix.get(i, i);
            for (int j = i; j < cols; j++) {
                matrix.set(i, j, matrix.get(i, j) / pivot);
            }

            // Eliminate all other rows
            for (int j = 0; j < rows; j++) {
                if (j != i) {
                    double factor = matrix.get(j, i);
                    for (int k = i; k < cols; k++) {
                        matrix.set(j, k, matrix.get(j, k) - factor * matrix.get(i, k));
                    }
                }
            }
        }

        // Display the results
        System.out.println("The matrix after Gauss-Jordan Elimination:");
        matrix.print();

        // Extract solutions
        double x1 = matrix.get(0, 3);
        double x2 = matrix.get(1, 3);
        double x3 = matrix.get(2, 3);

        System.out.printf("x1 = %.2f\n", x1);
        System.out.printf("x2 = %.2f\n", x2);
        System.out.printf("x3 = %.2f\n", x3);
    }
}
