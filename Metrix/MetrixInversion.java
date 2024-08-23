package com.mycompany.metrixmaven;

import org.ejml.simple.SimpleMatrix;

public class MetrixInversion {
    public static void main(String[] args) {
        double[][] A = {
                {-2, 3, 1},
                {3, 4, -5},
                {1, -2, 1}
        };
        
        double[][] B = {
            {9},
            {0},
            {-4}
        };

        SimpleMatrix matrixA = new SimpleMatrix(A);
        SimpleMatrix matrixB = new SimpleMatrix(B);

        if (matrixA.numRows() == matrixA.numCols()) {
            SimpleMatrix inverseMatrix = invertMatrix(matrixA);

            if (inverseMatrix != null) {
                inverseMatrix.print();
                SimpleMatrix findX = inverseMatrix.mult(matrixB);
                findX.print();
            } else {
                System.out.println("Matrix inversion is not possible.");
            }
        } else {
            System.out.println("Matrix inversion is not possible.");
        }
    }

    public static SimpleMatrix invertMatrix(SimpleMatrix matrix) {
        int n = matrix.numRows();
        SimpleMatrix augmentedMatrix = new SimpleMatrix(n, 2 * n);

        // Form the augmented matrix [A | I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix.set(i, j, matrix.get(i, j));
            }
            augmentedMatrix.set(i, i + n, 1.0);
        }

        // Apply Gauss-Jordan elimination
        for (int i = 0; i < n; i++) {
            // Make the diagonal contain all 1's
            double diagElement = augmentedMatrix.get(i, i);
            if (diagElement == 0) {
                return null; // Matrix is singular, no inverse exists
            }
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix.set(i, j, augmentedMatrix.get(i, j) / diagElement);
            }

            // Make the other columns contain 0's
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentedMatrix.get(k, i);
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix.set(k, j, augmentedMatrix.get(k, j) - factor * augmentedMatrix.get(i, j));
                    }
                }
            }
        }
        // Extract the inverse matrix
        SimpleMatrix inverseMatrix = new SimpleMatrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMatrix.set(i, j, augmentedMatrix.get(i, j + n));
            }
        }

        return inverseMatrix;
    }
}