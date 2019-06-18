class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        for (int i = 1; i <= num.length() / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) return false;
            String num1 = num.substring(0, i);
            for (int j = 1; num.length() - i - j >= Math.max(i, j); j++) {
                if (num.charAt(i) == '0' && j > 1) break;
                String num2 = num.substring(i, i + j);
                if (isValid(num1, num2, i + j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(String num1, String num2, int i, String num) {
        if (i == num.length()) return true;
        String num3 = stringAdd(num1, num2);
        return num.startsWith(num3, i) && isValid(num2, num3, i + num3.length(), num);
    }

    private String stringAdd(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int d1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int d2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int d = d1 + d2 + carry;
            if (d > 9) {
                d -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            i--;
            j--;
            sb.insert(0, "" + d);
        }
        if (carry == 1) sb.insert(0, "" + 1);
        return sb.toString();
    }
}
