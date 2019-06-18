class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        int pre = 0;
        Stack<Integer> s = new Stack<>();
        for (String log : logs) {
            String[] l = log.split(":");
            int id = Integer.parseInt(l[0]), cur = Integer.parseInt(l[2]);
            String status = l[1];
            if (status.equals("start")) {
                if (!s.isEmpty()) res[s.peek()] += cur - pre;
                s.push(id);
                pre = cur;
            } else {
                res[s.peek()] += cur - pre + 1;
                s.pop();
                pre = cur + 1;
            }
        }
        return res;
    }
}
