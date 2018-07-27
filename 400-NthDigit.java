class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int i = 0;
        while (n > 9 * Math.pow(10, i) * (i + 1)) {
            n -= 9 * Math.pow(10, i) * (i + 1);
            i++;
        }
        int pos = n % (i + 1) == 0 ? i : (n % (i + 1) - 1);
        int num = (int)Math.pow(10, i) + n / (i + 1);
        if (pos == i) num -= 1;
        return (num + "").charAt(pos) - '0';
    }
}
