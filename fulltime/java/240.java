class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = m - 1; i >= 0; i--) {
            if (matrix[i][0] == target) return true;
            else if (matrix[i][0] < target) {
                boolean find = binarySearch(matrix[i], target);
                if (find) return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int cur = nums[mid];
            if (cur == target) return true;
            else if (cur < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return nums[lo] == target || nums[hi] == target;
    }
}
