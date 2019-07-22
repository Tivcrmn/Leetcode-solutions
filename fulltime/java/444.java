class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        List<Integer>[] outdegrees = new List[org.length + 1];
        int[] indegrees = new int[org.length + 1];
        boolean[] visited = new boolean[org.length + 1];
        for (int i = 1; i < outdegrees.length; i++) {
            outdegrees[i] = new ArrayList<Integer>();
        }
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                int pre = seq.get(i);
                if (pre < 0 || pre > org.length) return false;
                visited[pre] = true;
                if (i < seq.size() - 1) {
                    int nex = seq.get(i + 1);
                    if (nex < 0 || nex > org.length) return false;
                    visited[nex] = true;
                    outdegrees[pre].add(nex);
                    indegrees[nex]++;
                }
            }
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= org.length; i++) {
            if (visited[i]) count++;
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        if (count != org.length) return false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size != 1) return false;
            int cur = queue.poll();
            count--;
            for (int next : outdegrees[cur]) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == 0;
    }
}
