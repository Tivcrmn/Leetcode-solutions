class Solution {
    public String crackSafe(int n, int k) {
        Set<String> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append("0");
        }
        set.add(ans.toString());
        if (helper(ans, set, n, k)) return ans.toString();
        return "";
    }

    private boolean helper(StringBuilder ans, Set<String> set, int n, int k) {
        if (set.size() == Math.pow(k, n)) return true;
        String prefix = ans.substring(ans.length() - n + 1, ans.length());
        for (char i = '0'; i < '0' + k; i++) {
            String item = prefix + i;
            if (set.contains(item)) continue;
            else {
                set.add(item);
                ans.append(i);
                if (helper(ans, set, n, k)) return true;
                set.remove(item);
                ans.setLength(ans.length() - 1);
            }
        }
        return false;
    }
}
