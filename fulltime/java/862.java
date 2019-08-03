class Solution {
    public int shortestSubarray(int[] A, int K) {
        TreeMap<Long, Integer> tree = new TreeMap<>();
        long total = 0;
        int minLen = A.length + 1;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            Long num = tree.floorKey(total - K);
            if (total >= K) {
                minLen = Math.min(minLen, i + 1);
            }
            while (num != null) {
                minLen = Math.min(minLen, i - tree.get(num));
                tree.remove(num);
                num = tree.lowerKey(num);
            }
            tree.put(total, i);
        }
        return minLen == A.length + 1 ? -1 : minLen;
    }
}
