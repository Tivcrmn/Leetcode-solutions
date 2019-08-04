class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[routes.length];
        Set<Integer> visitedBus = new HashSet<>();
        int count = 0;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int cur = routes[i][j];
                if (cur == S) {
                    queue.offer(i);
                    visited[i] = true;
                }
                if (!map.containsKey(cur)) {
                    map.put(cur, new ArrayList<Integer>());
                }
                map.get(cur).add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : routes[cur]) {
                    if (next == T) return count;
                    if (visitedBus.contains(next)) continue;
                    List<Integer> nextBuses = map.get(next);
                    if (nextBuses != null) {
                        boolean used = true;
                        for (int nextBus : nextBuses) {
                            if (!visited[nextBus]) {
                                queue.offer(nextBus);
                                visited[nextBus] = true;
                                used = false;
                            }
                        }
                        if (used) visitedBus.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
