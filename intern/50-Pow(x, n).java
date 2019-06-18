class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if (n > 0) {
            res = helper(x, n);
        } else {
            res = 1.0 / helper(x, n);
        }
        return res;
    }

    private double helper(double x, int n) {
        double res = 0;
        if (n == 0) {
            return 1;
        } else {
            double y = helper(x, n / 2);
            if (n % 2 == 0) {
                res = y * y;
            } else {
                res = y * y * x;
            }
        }
        return res;
    }
}
