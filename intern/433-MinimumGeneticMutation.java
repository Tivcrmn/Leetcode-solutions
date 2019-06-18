class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> banks = new HashSet<>();
        for (String s : bank) {
            banks.add(s);
        }
        int len = 0;
        queue.offer(start);
        set.add(start);
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int n = 0; n < size; n++) {
                String s = queue.poll();
                for (int i = 0; i < 8; i++) {
                    for (int j = 1; j <= 3; j++) {
                        String m = mutation(s, i, j);
                        if (banks.contains(m)) {
                            if (m.equals(end)) return len;
                            if (set.contains(m)) continue;
                            set.add(m);
                            queue.offer(m);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private String mutation(String s, int index, int add) {
        char[] genes = new char[]{'A', 'C', 'G', 'T'};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < genes.length; i++) {
            map.put(genes[i], i);
        }
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(index, genes[(map.get(s.charAt(index)) + add) % 4]);
        return sb.toString();
    }
}
