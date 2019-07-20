class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> next = new ArrayList<>();
        int[] min = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = quiet[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = i;
        }
        for (int i = 0; i < n; i++) {
            next.add(new ArrayList<>());
        }
        for (int[] pair : richer) {
            int rich = pair[0], poor = pair[1];
            next.get(poor).add(rich);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(next, i, min, visited, quiet, res);
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> next,
                     int i,
                     int[] min,
                     Set<Integer> visited,
                     int[] quiet,
                     int[] res) {
        visited.add(i);
        for (int nex : next.get(i)) {
            if (!visited.contains(nex)) {
                dfs(next, nex, min, visited, quiet, res);
            }
            if (min[i] > min[nex]) {
                min[i] = min[nex];
                res[i] = res[nex];
            }
        }
    }
}
