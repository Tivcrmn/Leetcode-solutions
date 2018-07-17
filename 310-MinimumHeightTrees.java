// TLS.........
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) return new ArrayList<>();
        Map<Integer, List<Integer>> mapEdges = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            mapEdges.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            mapEdges.get(edge[0]).add(edge[1]);
            mapEdges.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            int length = 0;
            int size = 1;
            queue.offer(i);
            while (!queue.isEmpty()) {
                length++;
                if (length > minLength) break;
                int temp = 0;
                for (int j = 0; j < size; j++) {
                    int node = queue.poll();
                    visited[node] = true;
                    for (Integer nd : mapEdges.get(node)) {
                        if (!visited[nd]) {
                            queue.offer(nd);
                            temp++;
                        }
                    }
                }
                size = temp;
            }
            if (res.size() == 0 && minLength != Integer.MAX_VALUE) {
                res.add(i);
                minLength = length;
            } else {
                if (minLength == length) {
                    res.add(i);
                } else if (minLength > length) {
                    res = new ArrayList<>();
                    res.add(i);
                    minLength = length;
                }
            }
        }
        return res;
    }
}
