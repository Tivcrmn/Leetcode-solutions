class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (K > 26) return 0;
        int distinct = 0;
        int[] letters = new int[26];
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            int cur = S.charAt(i) - 'a';
            letters[cur]++;
            if (letters[cur] == 1) distinct++;
            if (i >= K) {
                int pre = S.charAt(i - K) - 'a';
                letters[pre]--;
                if (letters[pre] == 0) distinct--;
            }
            if (distinct == K) count++;
        }
        return count;
    }
}
