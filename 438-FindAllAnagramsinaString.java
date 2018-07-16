class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] freqs = new int[26];
        for (Character ch : p.toCharArray()) {
            freqs[ch - 'a']++;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] subFreqs = new int[26];
            for (int j = 0; ; j++) {
                if (j == p.length()) {
                    res.add(i);
                    break;
                }
                int index = s.charAt(i + j) - 'a';
                if (freqs[index] == 0) break;
                else {
                    subFreqs[index]++;
                    if (subFreqs[index] > freqs[index]) break;
                }
            }
        }
        return res;
    }
}
