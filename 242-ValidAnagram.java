class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] alphas = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphas[s.charAt(i) - 'a']++;
            alphas[t.charAt(i) - 'a']--;
        }
        for (int alpha : alphas) {
            if (alpha != 0) return false;
        }
        return true;
    }
}
