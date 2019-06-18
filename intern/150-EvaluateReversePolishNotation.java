class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<String> s = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = Integer.parseInt(s.pop());
                int num1 = Integer.parseInt(s.pop());
                int res = 0;
                switch (token) {
                    case "+": res = num1 + num2; break;
                    case "-": res = num1 - num2; break;
                    case "*": res = num1 * num2; break;
                    case "/": res = num1 / num2; break;
                }
                s.push(res + "");
            } else s.push(token + "");
        }
        return Integer.parseInt(s.pop());
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
