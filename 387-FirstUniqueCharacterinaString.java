class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int[] freqs = new int[26];
        int[] first = new int[26];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            first[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i) - 'a']++;
            first[s.charAt(i) - 'a'] = Math.min(first[s.charAt(i) - 'a'], i);
        }
        for (int i = 0; i < 26; i++) {
            if (freqs[i] == 1) res = Math.min(first[i], res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
