public class LinearRegression {
    public static void main(String[] args) {
        double[] x = {10, 15, 20, 30, 40, 50, 60, 70, 80};
        double[] y = {5, 9, 15, 18, 22, 30, 35, 38, 43};

        int n = x.length;
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;

        for (int i = 0; i < n; i++) {
            sumX += x[i];
            sumY += y[i];
            sumXY += x[i] * y[i];
            sumX2 += x[i] * x[i];
        }

        double a1 = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double a0 = (sumY - a1 * sumX) / n;

        System.out.println("Linear Regression Equation: f(x) = " + a0 + " + " + a1 + " * x");

        // Predict f(65)
        double xPred = 65;
        double yPred = a0 + a1 * xPred;
        System.out.println("Predicted f(65): " + yPred);
    }
}
