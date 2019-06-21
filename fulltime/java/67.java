class Solution {
    public String addBinary(String a, String b) {
        int pa = a.length() - 1, pb = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (pa >= 0 || pb >= 0) {
            int da = pa >= 0 ? a.charAt(pa--) - '0' : 0;
            int db = pb >= 0 ? b.charAt(pb--) - '0' : 0;
            int sum = da + db + carry;
            sb.append(sum % 2 + "");
            carry = sum / 2;
        }
        if (carry == 1) sb.append("1");
        return sb.reverse().toString();
    }
}
