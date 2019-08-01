class Solution {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        int max = 0, i = 0;
        while (i < A.length - 1) {
            while (i < A.length - 1 && A[i] >= A[i + 1]) i++;
            int start = i;
            while (i < A.length - 1 && A[i] < A[i + 1]) i++;
            while (i < A.length - 1 && A[i] > A[i + 1]) i++;
            int len = i - start + 1;
            if (len >= 3 && A[start] < A[start + 1] && A[i - 1] > A[i]) {
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
