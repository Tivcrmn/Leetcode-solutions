class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        int[] sizes = new int[edges.length + 1];
        Arrays.fill(sizes, 1);
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int pu = find(u, parents);
            int pv = find(v, parents);
            if (pu == pv) return edge;
            if (sizes[pu] < sizes[pv]) {
                parents[pu] = pv;
                sizes[pv] += sizes[pu];
            } else {
                parents[pv] = pu;
                sizes[pu] += sizes[pv];
            }
        }
        return null;
    }

    private int find(int node, int[] parents) {
        while (node != parents[node]) {
            node = parents[node];
        }
        return node;
    }
}
