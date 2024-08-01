/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

/**
 *
 * @author USER
 */
public class Rapson {
    public static void main(String[] args) {
        double x = 2;
        double tolerance = 1e-6;
        int maxIteration = 1000;
        double ans = NewtonRapson(x,tolerance,maxIteration);
        if(ans != -1){
            System.out.printf("Answer is : %.6f\n",ans );
        }
        else{
            System.out.println("No answer");
        }
    }
    
    public static double f(double x){
        return Math.pow(x, 2) - 7;
    }
    
    public static double fd(double x){
        return 2*x;
    }
    
    public static double NewtonRapson(double x,double tolerance,int maxIteration){
        double newX;
        int Iteration = 1;
        while(Iteration <= maxIteration){
            newX = x - (f(x)/fd(x));
            if(Math.abs(newX - x) < tolerance){
                return newX;
            }
            
            x = newX;
            Iteration++;
        }
        return -1;
    }
}
