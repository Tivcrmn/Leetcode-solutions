class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    temp[k] += matrix[j][k];
                }
                count += getCounts(temp, target);
            }
        }
        return count;
    }

    private int getCounts(int[] temp, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int presum = 0, count = 0;
        for (int i = 0; i < temp.length; i++) {
            presum += temp[i];
            Integer c = map.get(presum - target);
            if (c != null) {
                count += c;
            }
            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
