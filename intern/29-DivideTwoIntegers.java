class Solution {
    public int divide(int dividend, int divisor) {
        long ans = 0;
        if (dividend == 0 || Math.abs((long)dividend) < Math.abs((long)divisor)) {
            return 0;
        }
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = -1;
        }
        ans = divide(Math.abs((long)dividend), Math.abs((long)divisor));
        if (sign == 1 && ans > Integer.MAX_VALUE || sign == -1 && ans < Integer.MIN_VALUE) {
            ans = Integer.MAX_VALUE;
        }
        return (int) ans * sign;
    }

    private long divide(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long sum = divisor;
        long multiply = 1;
        while (dividend >= sum + sum) {
            sum += sum;
            multiply += multiply;
        }
        return multiply + divide(dividend - sum, divisor);

    }
}
