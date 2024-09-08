package com.mycompany.metrixmaven;
import org.ejml.simple.SimpleMatrix;

public class GaussSeidel {
    public static void main(String[] args) {
        double[][] A = {
            {5, 2, 0, 0},
            {2, 5, 2, 0},
            {0, 2, 5, 2},
            {0, 0, 2, 5}
        };
        double[][] B = {{12}, {17}, {14}, {7}};
        double[][] X = {{0}, {0}, {0}, {0}};

        SimpleMatrix matrixA = new SimpleMatrix(A);
        SimpleMatrix matrixB = new SimpleMatrix(B);
        SimpleMatrix matrixX = new SimpleMatrix(X);
        double epsilon = 0.000001;
        int iteration = 0;

        while (true) {
            double maxError = 0;

            for (int i = 0; i < matrixX.numRows(); i++) {
                double sum = 0;
                for (int j = 0; j < matrixX.numRows(); j++) {
                    if (i != j) sum += matrixA.get(i, j) * matrixX.get(j);
                }

                double newX = (matrixB.get(i) - sum) / matrixA.get(i, i);
                maxError = Math.max(maxError, Math.abs(newX - matrixX.get(i)));
                matrixX.set(i, newX);  // Update immediately for Gauss-Seidel
            }

            iteration++;

            if (maxError < epsilon) break;
        }

        System.out.println("Number of iterations: " + iteration);
        System.out.println("Solution vector (x):");
        matrixX.print();
    }
}
