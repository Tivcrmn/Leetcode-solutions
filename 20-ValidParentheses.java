class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<String> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push("]");
            } else if (ch == '(') {
                stack.push(")");
            } else if (ch == '{') {
                stack.push("}");
            } else if (stack.isEmpty() || !stack.pop().equals(ch + "")) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
