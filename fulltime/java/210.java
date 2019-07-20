class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (numCourses <= 0) return res;
        List<Set<Integer>> outdegrees = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            outdegrees.add(new HashSet<Integer>());
        }
        int[] indegrees = new int[numCourses];
        int remain = numCourses;
        for (int[] prerequisite : prerequisites) {
            int cur = prerequisite[0], pre = prerequisite[1];
            indegrees[cur]++;
            Set<Integer> next = outdegrees.get(pre);
            next.add(cur);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[numCourses - remain] = cur;
            remain--;
            for (int next : outdegrees.get(cur)) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return remain == 0 ? res : new int[]{};
    }
}
