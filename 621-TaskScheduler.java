class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        int k = 0;
        for (Character task : tasks) {
            freqs[task - 'A']++;
        }
        Arrays.sort(freqs);
        for (int i = 25; i >= 0; i--) {
            if (freqs[i] == freqs[25]) {
                k++;
            } else {
                break;
            }
        }
        return Math.max((n + 1) * (freqs[25] - 1) + k, tasks.length);
    }
}
