class Solution {
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        // it is brute force.. and can pass
        int N = workers.length, M = bikes.length;
        boolean[] visited = new boolean[M];
        dfs(0, workers, bikes, visited, 0);
        return min;
    }

    private void dfs(int curWorker,
                     int[][] workers,
                     int[][] bikes,
                     boolean[] visited,
                     int curDistance) {
        if (curDistance >= min) return;
        if (curWorker == workers.length) {
            min = Math.min(min, curDistance);
            return;
        }
        for (int i = 0; i < bikes.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int increment = calc(workers[curWorker], bikes[i]);
                dfs(curWorker + 1, workers, bikes, visited, curDistance + increment);
                visited[i] = false;
            }
        }
    }

    private int calc(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
