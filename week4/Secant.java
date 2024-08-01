/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4;

/**
 *
 * @author USER
 */
public class Secant {
    public static void main(String[] args){
        double x0 = 1;
        double x = 2;
        double telerance = 1e-6;
        int MaxIteration = 1000;
        
        double ans = Secant(x0,x,telerance,MaxIteration);
        
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
    
    public static double Secant(double x0,double x,double tolerance,int MaxIteration){
        double newX;
        int Iteration = 1;
        while(Iteration <= MaxIteration){
            newX = x - (f(x)*(x0 - x)/(f(x0)-f(x)));
            if(Math.abs(newX - x) < tolerance){
                return newX;
            }
            x0 = x;
            x = newX;
            Iteration++;
        }
        return -1;
    }
}
