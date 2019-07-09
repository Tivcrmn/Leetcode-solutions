class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return helper(x, n);
    }

    private double helper(double x, int n) {
        double res = 0.0;
        if (n == 0) return 1.0;
        double y = helper(x, n / 2);
        if (n % 2 == 0) {
            res = y * y;
        } else {
            res = y * y * x;
        }
        return res;
    }
}
