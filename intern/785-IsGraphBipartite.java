class Solution {
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length <= 2) return true;
        boolean[] visited = new boolean[graph.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        while (count < graph.length) {
            for (int i = 0; i < graph.length; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                count++;
                if (graph[i].length > 0) {
                    queue.offer(i);
                    s1.add(i);
                    break;
                }
            }
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int edge : graph[node]) {
                    if (visited[edge]) continue;
                    Set<Integer> s = s1.contains(node) ? s2 : s1;
                    for (int e : graph[edge]) {
                        if (s.contains(e)) return false;
                    }
                    s.add(edge);
                    count++;
                    visited[edge] = true;
                    queue.offer(edge);
                }
            }

        }

        return true;
    }
}
