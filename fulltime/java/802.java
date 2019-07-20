class Solution {
    // TLE... 
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] hasCycle = new boolean[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasCycle[i]) dfs(i, hasCycle, new HashSet<>(), graph);
        }
        for (int i = 0; i < n; i++) {
            if (!hasCycle[i]) res.add(i);
        }
        return res;
    }

    private void dfs(int cur, boolean[] hasCycle, Set<Integer> path, int[][] graph) {
        if (path.contains(cur) || hasCycle[cur]) {
            for (int node : path) {
                hasCycle[node] = true;
            }
            return;
        }
        for (int next : graph[cur]) {
            path.add(cur);
            dfs(next, hasCycle, path, graph);
            path.remove(cur);
        }
    }
}
