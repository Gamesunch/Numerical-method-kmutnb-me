package com.mycompany.metrixmaven;

import org.ejml.simple.SimpleMatrix;

public class LUDecomposition {
    public static void main(String[] args) {
        double[][] MatrixA = {
            {-2, 3, 1},
            {3, 4, -5},
            {1, -2, 1}
        };

        double[][] MatrixB = {
            {9},
            {0},
            {-4}
        };
        
        SimpleMatrix A = new SimpleMatrix(MatrixA);
        SimpleMatrix B = new SimpleMatrix(MatrixB);
        
        int SizeA = A.numRows();
        SimpleMatrix L = new SimpleMatrix(SizeA,SizeA);
        SimpleMatrix U = new SimpleMatrix(SizeA,SizeA);
        
        //Row1
        L.set(0, 0, A.get(0,0)); //L(1,1)
        U.set(0, 1, A.get(0,1) / L.get(0,0)); //U(1,2)
        U.set(0, 2, A.get(0,2) / L.get(0,0)); //U(1,3)
        //Row2
        L.set(1, 0, A.get(1,0)); //L(2,1)
        L.set(1, 1, A.get(1,1) - ((L.get(1,0) * U.get(0,1))) ); //L(2,2)
        U.set(1, 2, (A.get(1,2) - ((L.get(1,0) * U.get(0,2)))) / L.get(1,1)); //U(2,3)
        //Row3
        L.set(2, 0, A.get(2,0)); //L(3,1)
        L.set(2, 1, A.get(2,1) - ((L.get(2,0) * U.get(0,1))) ); //L(3,2)
        L.set(2, 2, A.get(2,2) - ((L.get(2,0) * U.get(0,2))) - ((L.get(2,1) * U.get(1,2))) ); //L(3,3)
        
        L.print();
        U.print();
        
        int SizeBrows = B.numRows();
        int SizeBcols = B.numCols();
        
        SimpleMatrix Y = new SimpleMatrix(SizeBrows,SizeBcols);
        SimpleMatrix X = new SimpleMatrix(SizeBrows,SizeBcols);
        
        //L * Y = B: (find Y);
        Y.set(0, 0, B.get(0, 0) / L.get(0, 0));
        Y.set(1, 0, (B.get(1, 0) - (L.get(1,0) * Y.get(0,0) ) ) / L.get(1, 1));
        Y.set(2, 0, (B.get(2, 0) - (L.get(2,0) * Y.get(0,0)) - (L.get(2,1) * (Y.get(1,0)))) / L.get(2, 2));
        
        // U * X = Y;
        X.set(2, 0, Y.get(2,0)); //x3
        X.set(1, 0, Y.get(1,0) - (U.get(1,2)*X.get(2,0)) ); //x2
        X.set(0, 0, Y.get(0,0) - (U.get(0,1) * X.get(1,0)) - (U.get(0,2) * (X.get(2,0))) ); //x1
        
        
        Y.print();
        X.print();
        
        
    }
}
