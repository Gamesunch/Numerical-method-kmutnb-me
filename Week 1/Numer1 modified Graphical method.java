/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author USER
 */
public class Numer1 {
    
     public static double f(double x) {
        return 43 * x - 180;
    }

    public static double modifiedGraphicalMethod() {
        double y = Double.NaN, z = Double.NaN;


        for (int x = 0; x <= 10; x++) {
            double fx = f(x);
            if (fx == 0) {
                return x; 
            } else if (fx * f(x + 1) < 0) { 
                y = x;
                z = x + 1;
                break;
            }
        }
        
        //if Y or Z have no condinate;
        if (Double.isNaN(y) || Double.isNaN(z)) {
            return Double.NaN; 
        }

        for (double x = y; x <= z; x += 0.000001) {
            double fx = f(x);
            if (fx == 0) {
                return x; 
            } else if (fx * f(x + 0.000001) < 0) { 
                return (x + x + 0.000001) / 2; 
            }
        }

        return Double.NaN; 
    }
    
    public static void main(String[] args) {
        double solution = modifiedGraphicalMethod();
        if (!Double.isNaN(solution)) {
            System.out.printf("Answer is x = %.6f\n", solution);
        } else {
            System.out.println("No answer");
        }
    }

}
