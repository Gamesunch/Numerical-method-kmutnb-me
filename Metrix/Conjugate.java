package com.mycompany.metrixmaven;

import org.ejml.simple.SimpleMatrix;

public class Conjugate {
    public static void main(String[] args) {
        double[][] A = {
            {5, 2, 0, 0},
            {2, 5, 2, 0},
            {0, 2, 5, 2},
            {0, 0, 2, 5}
        };

        double[][] B = {{12}, {17}, {14}, {7}};
        double[][] X = {{0}, {0}, {0}, {0}}; // Initial guess for X

        SimpleMatrix matrixA = new SimpleMatrix(A);
        SimpleMatrix matrixB = new SimpleMatrix(B);
        SimpleMatrix matrixX = new SimpleMatrix(X);
        
        SimpleMatrix r = matrixB.minus(matrixA.mult(matrixX)); // Initial residual
        SimpleMatrix p = r.copy(); // Initial direction
        double epsilon = 1e-6; // Convergence tolerance
        int iteration = 0;
        
        while (r.normF() > epsilon) {
            iteration++;

            SimpleMatrix Ap = matrixA.mult(p);
            double alpha = r.dot(r) / p.dot(Ap); // Step size
            
            matrixX = matrixX.plus(p.scale(alpha)); // Update X
            SimpleMatrix rNew = r.minus(Ap.scale(alpha)); // Update residual
            
            if (rNew.normF() < epsilon) break; // Check for convergence

            double beta = rNew.dot(rNew) / r.dot(r); // Compute the new beta
            p = rNew.plus(p.scale(beta)); // Update direction
            r = rNew; // Update residual for next iteration
        }

        System.out.println("Number of iterations: " + iteration);
        System.out.println("Solution vector (x):");
        matrixX.print();
    }
}
