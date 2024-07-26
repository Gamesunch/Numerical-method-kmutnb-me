/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package numerweek3;

public class Numerweek3 {
    
    public static void main(String[] args) {
        double x = 1;
        double tolerance = 1e-6;
        int maxIteration = 1000;
        double ans = OnepointIteration(x,tolerance,maxIteration);
        if(ans != -1){
            System.out.printf("Answer is : %.6f\n",ans );
        }
        else{
            System.out.println("No answer");
        }
    }
    
    public static double f(double x){
        return (x+7/x)/2;   // x^2 - 7 = 0 Convert to (x+7/x)/2
    }
    
    public static double OnepointIteration(double x,double tolerance,int maxIteration){
        double newX;
        int Iteration = 1;
        while(Iteration <= maxIteration){
            newX = f(x);
            if(Math.abs(newX-x) < tolerance){
                return newX;
            }
            x = newX;
            Iteration++;
        }
        return -1;
    }
}
