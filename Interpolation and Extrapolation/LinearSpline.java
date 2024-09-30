public class LinearSpline {

    private double[] x;  // xi
    private double[] y;  // yi (fx)
    private int n;       // number of intervals

    public LinearSpline(double[] x, double[] y) {
        if (x.length != y.length || x.length < 2) {
            throw new IllegalArgumentException("Invalid input data.");
        }
        this.x = x;
        this.y = y;
        this.n = x.length - 1; // number of intervals
    }

    
    public double interpolate(double x_val) {
        int i = findInterval(x_val);

        // Linear interpolation formula
        double slope = (y[i+1] - y[i]) / (x[i+1] - x[i]);
        return y[i] + slope * (x_val - x[i]);
    }

    // Find the correct interval for the given x_val
    private int findInterval(double x_val) {
        if (x_val < x[0] || x_val > x[n]) {
            throw new IllegalArgumentException("x_val is out of bounds.");
        }
        
        for (int i = 0; i < n; i++) {
            if (x_val >= x[i] && x_val <= x[i+1]) {
                return i;
            }
        }
        return n - 1;  // Last value
    }

    public static void main(String[] args) {
        double[] x = {2, 4, 6, 8, 10};
        double[] y = {9.5, 8, 10.5, 39.5, 72.5};

        LinearSpline spline = new LinearSpline(x, y);

        double x_val = 4.5;
        System.out.println("Interpolated value at " + x_val + " = " + spline.interpolate(x_val));
    }
}
