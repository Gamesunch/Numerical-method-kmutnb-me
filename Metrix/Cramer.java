/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.metrixmaven;

import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author USER
 */
public class Cramer {
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

        // Calculate the determinant of the original matrix A
        double detA = matrixA.determinant();

        if (detA == 0) {
            System.out.println("System has no unique solution (determinant is 0)");
        }  else {
            // Apply Cramer's Rule to find solutions
            double[] solutions = new double[A.length]; //have x1,x2,x3 inside;
            for (int i = 0; i < A.length; i++) {
                SimpleMatrix tempMatrix = matrixA.copy();
                // Replace the i-th column using setColumn()
                for (int j = 0; j < A.length; j++) {
                    tempMatrix.set(j, i, matrixB.get(j, 0)); // Access elements using get() and set()
                }
                double detAi = tempMatrix.determinant();
                solutions[i] = detAi / detA;
            }

            // Print the solutions
            System.out.println("Solutions:");
            for (int i = 0; i < solutions.length; i++) {
                System.out.println("x" + (i + 1) + " = " + solutions[i]);
            }
        }
    }
}
