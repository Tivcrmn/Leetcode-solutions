class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (Integer num : nums) {
            if (map.get(num) != null) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            freq[i] = new ArrayList<Integer>();
        }
        for (Integer key : map.keySet()) {
            freq[map.get(key)].add(key);
        }
        for (int i = nums.length; i >= 0; i--) {
            for (Integer item : freq[i]) {
                if (k == 0) {
                    return res;
                } else if (item != null) {
                    res.add(item);
                    k--;
                }
            }
        }
        return res;
    }
}
