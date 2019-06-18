class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder res = new StringBuilder();
        StringBuilder s1 = new StringBuilder(num1);
        StringBuilder s2 = new StringBuilder(num2);
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        while (n1 >= 0 || n2 >= 0) {
            int d1 = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int d2 = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            if (d1 + d2 + carry > 9) {
                res.insert(0, (d1 + d2 + carry - 10) + "");
                carry = 1;
            } else {
                res.insert(0, (d1 + d2 + carry) + "");
                carry = 0;
            }
            n1--;
            n2--;
        }
        if (carry == 1) res.insert(0, "1");
        return res.toString();
    }
}
