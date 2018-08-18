class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (map.containsKey(word)) map.put(word, map.get(word) + 1);
            else map.put(word, 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String w1, String w2) {
                int c1 = map.get(w1), c2 = map.get(w2);
                if (c1 == c2) return w2.compareTo(w1);
                else return c1 - c2;
            }
        });
        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) pq.poll();
        }
        while (!pq.isEmpty()) res.add(pq.poll());
        Collections.reverse(res);
        return res;
    }
}
