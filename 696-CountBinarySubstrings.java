class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 2) return 0;
        int zeros = 0;
        int ones = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
                if (ones >= zeros) res++;
                if (i <= s.length() - 2 && s.charAt(i + 1) == '1') ones = 0;
            } else {
                ones++;
                if (zeros >= ones) res++;
                if (i <= s.length() - 2 && s.charAt(i + 1) == '0') zeros = 0;
            }
        }
        return res;
    }
}
