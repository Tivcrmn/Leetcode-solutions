class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n < 1) {
            return res;
        }
        helper(res, "", n, n);
        return res;
    }

    private void helper(List<String> res, String ans, Integer left, Integer right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(ans);
            return;
        }
        if (left > 0) {
            helper(res, ans + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, ans + ")", left, right - 1);
        }
    }
}
