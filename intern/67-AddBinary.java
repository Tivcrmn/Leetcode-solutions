class Solution {
    public String addBinary(String a, String b) {
        String s1 = new StringBuilder(a).reverse().toString();
        String s2 = new StringBuilder(b).reverse().toString();
        StringBuilder res = new StringBuilder("");
        int carry = 0;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            int d1 = s1.charAt(i) - '0';
            int d2 = s2.charAt(i) - '0';
            if (d1 + d2 + carry < 2) {
                res.insert(0, "" + (d1 + d2 + carry));
                carry = 0;
            } else {
                res.insert(0, "" + (d1 + d2 + carry - 2));
                carry = 1;
            }
        }
        for (int i = Math.min(s1.length(), s2.length()); i < Math.max(s1.length(), s2.length()); i++) {
            int d = s1.length() > s2.length() ? s1.charAt(i) - '0' : s2.charAt(i) - '0';
            if (d + carry < 2) {
                res.insert(0, "" + (d + carry));
                carry = 0;
            } else {
                res.insert(0, "" + (d + carry - 2));
                carry = 1;
            }
        }
        if (carry == 1) {
            res.insert(0, "1");
        }
        return res.toString();
    }
}
