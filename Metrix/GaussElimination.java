package com.mycompany.metrixmaven;

import org.ejml.simple.SimpleMatrix;

public class GaussElimination { 
    public static void main(String[] args) {
        double[][] A = {
            {-2, 3, 1, 9},
            {3, 4, -5, 0},
            {1, -2, 1, -4}
        };

        SimpleMatrix matrix = new SimpleMatrix(A);
        int rows = matrix.numRows();
        int cols = matrix.numCols();

        // Gauss Elimination
        for (int i = 0; i < rows; i++) {
            double pivot = matrix.get(i, i);
            for (int j = i; j < cols; j++) {
                matrix.set(i, j, matrix.get(i, j) / pivot);
            }

            for (int j = i + 1; j < rows; j++) {
                double factor = matrix.get(j, i);
                for (int k = i; k < cols; k++) {
                    matrix.set(j, k, matrix.get(j, k) - factor * matrix.get(i, k));
                }
            }
        }

        // Back Substitution
        double x3 = matrix.get(2, 3) / matrix.get(2, 2);
        double x2 = (matrix.get(1, 3) - matrix.get(1, 2) * x3) / matrix.get(1, 1);
        double x1 = (matrix.get(0, 3) - matrix.get(0, 1) * x2 - matrix.get(0, 2) * x3) / matrix.get(0, 0);
        
        matrix.print();

        // Display results
        System.out.printf("x1 = %.2f\n", x1);
        System.out.printf("x2 = %.2f\n", x2);
        System.out.printf("x3 = %.2f\n", x3);
    }
}