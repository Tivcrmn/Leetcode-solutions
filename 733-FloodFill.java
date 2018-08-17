class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image, sr, sc, newColor, image[sr][sc], visited);
        return image;
    }

    private void helper(int[][] image,
                        int sr,
                        int sc,
                        int newColor,
                        int oldColor,
                        boolean[][] visited) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int nx = sr + dx[i];
            int ny = sc + dy[i];
            if (isValid(image.length, image[0].length, nx, ny) &&
                !visited[nx][ny] &&
                image[nx][ny] == oldColor)
                helper(image, nx, ny, newColor, oldColor, visited);
        }
    }

    private boolean isValid(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
