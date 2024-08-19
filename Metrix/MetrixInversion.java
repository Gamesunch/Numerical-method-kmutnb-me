package com.mycompany.metrixmaven;

import org.ejml.simple.SimpleMatrix;

public class MetrixInversion {
    public static void main(String[] args) {
        double[][] A = {
                {-2, 3, 1},
                {3, 4, -5},
                {1, -2, 1}
        };

        SimpleMatrix matrix = new SimpleMatrix(A);

        if (matrix.numRows() == matrix.numCols()) {
            SimpleMatrix inverseMatrix = matrix.invert();

            inverseMatrix.print();
        } else {
            System.out.println("Matrix inversion is not possible.");
        }
    }
}
