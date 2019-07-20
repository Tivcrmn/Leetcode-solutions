class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] color = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            int a = dislike[0], b = dislike[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= N; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while(!queue.isEmpty()) {
                    int cur = queue.poll();
                    for(int nb : graph.get(cur)) {
                        if(color[nb] == 0) {
                            color[nb] = color[cur] == 1 ? 2 : 1;
                            queue.add(nb);
                        } else {
                            if(color[nb] == color[cur]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
