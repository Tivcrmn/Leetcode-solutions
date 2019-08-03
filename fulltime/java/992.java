class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMost(A, K) - atMost(A, K - 1);
    }

    private int atMost(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, slow = 0;
        for (int fast = 0; fast < A.length; fast++) {
            map.put(A[fast], map.getOrDefault(A[fast], 0) + 1);
            while (map.size() > K) {
                int slowCount = map.get(A[slow]);
                if (slowCount == 1) {
                    map.remove(A[slow]);
                } else {
                    map.put(A[slow], slowCount - 1);
                }
                slow++;
            }
            count += fast - slow + 1;
        }
        return count;
    }
}
