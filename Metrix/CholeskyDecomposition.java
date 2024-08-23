package com.mycompany.metrixmaven;

import org.ejml.simple.SimpleMatrix;

public class CholeskyDecomposition {
    public static void main(String[] args) {
        double[][] MatrixA = {
            {4, 3, 1},
            {3, 5, 2},
            {1, 2, 6}
        };
        
        double[][] MatrixB = {
            {3125},
            {3650},
            {2800}
        };

        SimpleMatrix A = new SimpleMatrix(MatrixA);
        SimpleMatrix B = new SimpleMatrix(MatrixB);
        
        int SizeA = A.numRows();
        SimpleMatrix L = new SimpleMatrix(SizeA,SizeA);
        
        L.set(0, 0, Math.sqrt(A.get(0,0))); //set L(1,1);
        L.set(1, 0, ((A.get(0,1))/L.get(0, 0)) ); //set L(2,1);
        L.set(2, 0, ((A.get(0,2))/L.get(0, 0)) ); //set L(3,1);
        L.set(1, 1, Math.sqrt(A.get(1, 1) - (Math.pow(L.get(1,0),2))) ); //set L(2,2);
        L.set(2, 1, (A.get(1,2) - (L.get(1, 0) * L.get(2, 0)))/L.get(1,1)); //set L(3,2);
        L.set(2, 2, Math.sqrt(A.get(2,2) - Math.pow(L.get(2, 0), 2) - Math.pow(L.get(2, 1), 2))); //set L(3,3);
        
        L.print();
        
        SimpleMatrix LT = new SimpleMatrix(L.transpose());
        LT.print();
        
        int SizeBrows = B.numRows();
        int SizeBcols = B.numCols();
        
        SimpleMatrix Y = new SimpleMatrix(SizeBrows,SizeBcols);
        
        // L * Y = B (Find Y)
        Y.set(0, 0, B.get(0, 0) / L.get(0, 0));
        Y.set(1, 0, (B.get(1, 0) - (L.get(1,0) * Y.get(0,0) ) ) / L.get(1, 1));
        Y.set(2, 0, (B.get(2, 0) - (L.get(2,0) * Y.get(0,0)) - (L.get(2,1) * (Y.get(1,0)))) / L.get(2, 2));
        
        SimpleMatrix X = new SimpleMatrix(SizeBrows,SizeBcols);
        
        // Lt * X = Y (Find X)
        X.set(2, 0, Y.get(2,0)/LT.get(2, 2)); //x3
        X.set(1, 0, (Y.get(1,0) - (LT.get(1,2)*X.get(2,0))) / LT.get(1,1)); //x2
        X.set(0, 0, (Y.get(0,0) - (LT.get(0,2)*X.get(2,0)) - (LT.get(0,1)*X.get(1,0)) ) / LT.get(0,0)); //x1
        
        X.print();
        
    }
}