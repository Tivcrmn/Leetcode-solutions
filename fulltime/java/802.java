class Solution {
    Set<Integer> safeNodes;
    Set<Integer> cycleNodes;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        safeNodes = new HashSet<>();
        cycleNodes = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, new HashSet<Integer>())) res.add(i);
        }
        return res;
    }

    private boolean dfs(int[][] graph, int i, Set<Integer> visited) {
        if (safeNodes.contains(i)) return true;
        if (cycleNodes.contains(i)) return false;

        if (visited.contains(i)) {
            cycleNodes.add(i);
            return false;
        }

        visited.add(i);

        for (int n : graph[i]) {
            if (!dfs(graph, n, visited)) {
                cycleNodes.add(n);
                return false;
            }
        }

        safeNodes.add(i);
        return true;
    }
}
