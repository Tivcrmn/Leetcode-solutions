class Solution {
    public String countAndSay(int n) {
        String ans = "11";
        if (n <= 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        for (int i = 3; i <= n; i++) {
            String newAns = new String("");
            int count = 0;
            for (int j = 0; j < ans.length() - 1; j++) {
                count++;
                if (ans.charAt(j+1) != ans.charAt(j)) {
                    newAns += ("" + count + ans.charAt(j));
                    count = 0;
                }
            }
            if (ans.charAt(ans.length() - 1) != ans.charAt(ans.length() - 2)) {
                newAns += ("1" + ans.charAt(ans.length() - 1));
            } else {
                count++;
                newAns += ("" + count + ans.charAt(ans.length() - 1));
            }
            ans = newAns;
        }
        return ans;
    }
}
