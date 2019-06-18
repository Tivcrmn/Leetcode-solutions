class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        Arrays.sort(citations);
        int res = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - i <= citations[i] &&
                (i == 0 || citations[i - 1] <= citations.length - i)) res = citations.length - i;
        }
        return res;
    }
}
