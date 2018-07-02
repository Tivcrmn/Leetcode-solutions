class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        long ans = 0;
        int start = 0;
        int sign = 1;
        if (str.length() == 0) {
            return 0;
        } else if (str.charAt(0) == '+') {
            start = 1;
        } else if (str.charAt(0) == '-') {
            start = 1;
            sign = -1;
        } else if (Character.isDigit(str.charAt(0))) {
            // do nothing
        } else {
            return 0;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) ans * sign;
            }
            ans = ans * 10 + (str.charAt(i) - '0');
            if (sign == 1 && ans * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && ans * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) ans * sign;
    }
}
