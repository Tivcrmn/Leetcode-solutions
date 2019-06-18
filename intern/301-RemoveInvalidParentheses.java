class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new LinkedList<>();
        if (s == null) {
            return results;
        }
        int n = s.length();
        int l = 0;
        int r = 0;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(') {
                l++;
            }
            if (s.charAt(i) == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        helper(new StringBuilder(s), 0, l, r, results);
        return results;
    }

    private void helper(StringBuilder sb, int index, int l, int r, List<String> results){
        if (l == 0 && r == 0){
            if (isValid(sb)) {
                results.add(sb.toString());
            }
            return;
        }

        for (int i = index; i < sb.length(); i++) {
            if (i > index && sb.charAt(i) == sb.charAt(i - 1)) {
                continue;
            }

            if (sb.charAt(i) == '(' && l > 0) {
                sb.deleteCharAt(i);
                helper(sb, i, l - 1, r, results);
                sb.insert(i, '(');
            }

            if (sb.charAt(i) == ')' && r > 0) {
                sb.deleteCharAt(i);
                helper(sb, i, l, r - 1, results);
                sb.insert(i, ')');
            }
        }
    }

    private boolean isValid(StringBuilder sb){
        int left = 0, right = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                left++;
            }
            if (sb.charAt(i) == ')') {
                right++;
            }

            if (i < sb.length() - 1 && left < right) {
                return false;
            }
        }

        return left == right;
    }
}
