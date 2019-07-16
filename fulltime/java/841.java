class Solution {
    int size;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        size = rooms.size();
        boolean[] visited = new boolean[size];
        dfs(rooms, visited, 0);
        return size == 0;
    }

    private void dfs(List<List<Integer>> rooms, boolean[] visited, int cur) {
        visited[cur] = true;
        size--;
        for (int key : rooms.get(cur)) {
            if (!visited[key]) {
                dfs(rooms, visited, key);
            }
        }
    }
}
