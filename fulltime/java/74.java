class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int x = mid / n, y = mid % n;
            int cur = matrix[x][y];
            if (cur == target) return true;
            else if (cur < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return matrix[lo / n][lo % n] == target || matrix[hi / n][hi % n] == target;
    }
}
