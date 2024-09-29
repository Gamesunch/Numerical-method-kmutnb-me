import java.util.Scanner;

public class LagrangeInterpolation {

    // Function to perform Lagrange interpolation and display L_i(x) values
    public static double interpolate(double[] x, double[] y, double targetX, int[] selectedIndices) {
        double result = 0.0;
        int numPoints = selectedIndices.length;  // Number of selected points

        // Loop over each selected index
        for (int k = 0; k < numPoints; k++) {
            int i = selectedIndices[k]; // Get the actual index from selectedIndices array
            double term = y[i];
            double Li = 1.0;
            
            for (int m = 0; m < numPoints; m++) {
                int j = selectedIndices[m]; // Get the actual index from selectedIndices array
                if (j != i) {
                    term = term * (x[j] - targetX) / (x[j] - x[i]);
                    Li *= (x[j] - targetX) / (x[j] - x[i]); // Calculate L_i(x)
                }
            }
            
            // Display L_i(x) value
            System.out.println("L_" + (i+1) + "(x) = " + Li);
            
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample data points (x, y)
        double[] x = { 0, 20000, 40000, 60000, 80000 };
        double[] y = { 9.81, 9.7487, 9.6879, 9.6879, 9.5682 };

        // User input for interpolation type
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select interpolation type:");
        System.out.println("1. Linear (2 points)");
        System.out.println("2. Quadratic (3 points)");
        System.out.println("3. Polynomial (Select points)");

        int choice = scanner.nextInt();
        int numPoints = 0;

        switch (choice) {
            case 1: numPoints = 2; break; // Linear interpolation uses 2 points
            case 2: numPoints = 3; break; // Quadratic interpolation uses 3 points
            case 3: 
                System.out.print("Enter number of points you want to use for Polynomial interpolation: ");
                numPoints = scanner.nextInt(); 
                break;
            default:
                System.out.println("Invalid choice.");
                numPoints = x.length;
        }

        // Array to hold selected indices
        int[] selectedIndices = new int[numPoints];
        System.out.println("Enter the indices of the points to use (1 to " + (x.length) + "):");

        for (int i = 0; i < numPoints; i++) {
            System.out.print("Index " + (i + 1) + ": ");
            selectedIndices[i] = scanner.nextInt() - 1;
        }

        System.out.print("Enter the target X value to interpolate: ");
        double targetX = scanner.nextDouble();

        double interpolatedValue = interpolate(x, y, targetX, selectedIndices);

        
        System.out.println("Interpolated value at x = " + targetX + " is " + interpolatedValue);
    }
}
