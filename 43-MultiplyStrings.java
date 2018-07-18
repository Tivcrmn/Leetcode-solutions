class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        int[] digitSum = new int[s1.length() + s2.length()];
        int carry = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                digitSum[i + j] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
            }
        }
        StringBuilder res = new StringBuilder("");
        for (int k = 0; k < digitSum.length; k++) {
            int digit = digitSum[k] + carry;
            res.insert(0, digit % 10);
            carry = digit / 10 > 0 ? digit / 10 : 0;
        }
        int i = 0;
        while (i < digitSum.length && res.charAt(i) == '0') {
            i++;
        }
        return i == digitSum.length ? "0" : res.toString().substring(i);
    }
}
