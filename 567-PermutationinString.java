class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] freqs = new int[26];
        int[] slides = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freqs[s1.charAt(i) - 'a']++;
            slides[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if(isSame(freqs, slides)) return true;
            slides[s2.charAt(i) - 'a']--;
            if (i < s2.length() - s1.length()) slides[s2.charAt(i + s1.length()) - 'a']++;
        }
        return false;
    }

    private boolean isSame(int[] n1, int[] n2) {
        for (int i = 0; i < 26; i++) {
            if (n1[i] != n2[i]) return false;
        }
        return true;
    }
}
