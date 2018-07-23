class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) queue.offer(new int[]{i, j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int[] dx = new int[]{0, 0, 1, -1};
            int[] dy = new int[]{1, -1, 0, 0};
            for (int k = 0; k < 4; k++) {
                int x = pos[0] + dx[k];
                int y = pos[1] + dy[k];
                if (!isValid(x, y, m, n) ||
                    matrix[x][y] <= matrix[pos[0]][pos[1]] + 1) continue;
                queue.offer(new int[]{x, y});
                matrix[x][y] = matrix[pos[0]][pos[1]] + 1;
            }
        }
        return matrix;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
