class Solution {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] colors = new int[N];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !dfs(colors, graph, i, 1)) return false;
        }
        return true;
    }

    private boolean dfs(int[] colors, int[][] graph, int cur, int color) {
        if (colors[cur] != 0) {
            return colors[cur] == color;
        }
        colors[cur] = color;
        for (int neighbor : graph[cur]) {
            if (!dfs(colors, graph, neighbor, color == 1 ? 2 : 1)) return false;
        }
        return true;
    }
}
