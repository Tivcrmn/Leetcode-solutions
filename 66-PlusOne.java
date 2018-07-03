class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = null;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i >= 1; i--) {
            if (digits[i] > 9) {
                digits[i - 1] += 1;
                digits[i] = 0;
            }
        }
        if (digits[0] > 9) {
            digits[0] = 0;
            res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 1; i <= digits.length; i++) {
                res[i] = digits[i - 1];
            }
        } else {
            res = digits;
        }
        return res;
    }
}
