import java.util.Scanner;

public class NewtonInterpolation {

   //this is the code to cal f(x1)-f(x0)/x1-x0
    public static double dividedDifference(double[] x, double[] y, int i, int j) {
        if (i == j) {
            return y[i];
        }
        return (dividedDifference(x, y, i + 1, j) - dividedDifference(x, y, i, j - 1)) / (x[j] - x[i]);
    }

    /*
    this is to calculate P(x)=f[x0​]+(x−x0​)f[x0​,x1​]+(x−x0​)(x−x1​)f[x0​,x1​,x2​]+⋯ and so on.
    so we compute from backward to forward which this code do it.
    */
    public static double newtonPolynomial(double[] x, double[] y, int n, double value, int level) {
      /*
        value = x in formular 
      */
        if (level == 0) {
        //find c0
            return dividedDifference(x, y, 0, 0);
        }
        // (x-x0)(x-x1)(x-x2)...
        double term = dividedDifference(x, y, 0, level);
        for (int i = 0; i < level; i++) {
            term *= (value - x[i]);
        }
        /*
          c1(x-x0) + c2(x-x0)(x-x1)
        */
        return term + newtonPolynomial(x, y, n, value, level - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of data points
        System.out.print("Enter number of data points: ");
        int n = sc.nextInt();

        double[] x = new double[n];
        double[] y = new double[n];

        // Input data points
        System.out.println("Enter the data points (x, y): ");
        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextDouble();
            System.out.print("y[" + i + "]: ");
            y[i] = sc.nextDouble();
        }

        // Input the value the polynomial
        System.out.print("Enter the value to interpolate: ");
        double value = sc.nextDouble();

        // Evaluate the polynomial at the given value recursively
        double result = newtonPolynomial(x, y, n, value, n - 1);

        System.out.println("The interpolated value at " + value + " is: " + result);

        sc.close();
    }
}

