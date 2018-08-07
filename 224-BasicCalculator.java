class Solution {
    public int calculate(String s) {
        int res = 0, cur = 0, sign = 1;
        Stack<Integer> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                cur = cur * 10 + (ch - '0');
            } else if (ch == '+') {
                res += sign * cur;
                sign = 1;
                cur = 0;
            } else if (ch == '-') {
                res += sign * cur;
                sign = -1;
                cur = 0;
            } else if (ch == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (ch == ')') {
                res += sign * cur;
                res *= st.pop();
                res += st.pop();
                cur = 0;
                sign = 1;
            } else if (ch == ' ') continue;
        }
        if (cur != 0) res += sign * cur;
        return res;
    }
}
