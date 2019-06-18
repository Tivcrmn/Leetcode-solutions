class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> mapAB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int totalAB = A[i] + B[j];
                if (mapAB.containsKey(totalAB)) mapAB.put(totalAB, mapAB.get(totalAB) + 1);
                else mapAB.put(totalAB, 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (mapAB.containsKey(0 - C[i] - D[j])) res += mapAB.get(0 - C[i] - D[j]);
            }
        }
        return res;
    }
}
