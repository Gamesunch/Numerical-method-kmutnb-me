package com.mycompany.metrixmaven;

import org.ejml.simple.SimpleMatrix;

/**
 *
 * @author USER
 */
public class GaussElimination { 
    public static void main(String[] args) {
        double[][] A = {
                {-2, 3, 1, 9},
                {3, 4, -5, 0},
                {1, -2, 1, -4}
        };

        SimpleMatrix matrix = new SimpleMatrix(A);
        
        // Perform Gauss Elimination
        for (int i = 0; i < matrix.numRows(); i++) {
            // Normalize the pivot row
            double pivot = matrix.get(i, i);
            for (int j = i; j < matrix.numCols(); j++) {
                matrix.set(i, j, matrix.get(i, j) / pivot);
            }

            // Eliminate rows below
            for (int j = i + 1; j < matrix.numRows(); j++) {
                double factor = matrix.get(j, i);
                for (int k = i; k < matrix.numCols(); k++) {
                    matrix.set(j, k, matrix.get(j, k) - factor * matrix.get(i, k));
                }
            }
        }
        
        

        // Display the result
        System.out.println("The matrix after Gauss Elimination:");
        matrix.print();
        System.out.println("------------------------------------");
        
        double x3 = matrix.get(2,3)/matrix.get(2,2);
        double x2 = (matrix.get(1,3) - matrix.get(1,2)*x3)/matrix.get(1,1);
        double x1 = (matrix.get(0,3)-matrix.get(0,1)*x2-matrix.get(0,2)*x3)/matrix.get(0,0);
        
        System.out.printf("%.2f\n",x1);
        System.out.printf("%.2f\n",x2);
        System.out.printf("%.2f\n",x3);
    }
}
