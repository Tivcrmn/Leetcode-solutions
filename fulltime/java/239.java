class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k < 1) return nums;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i >= k - 1) {
                int index = i - k + 1;
                res[index] = map.lastKey();
                int count = map.get(nums[index]);
                if (count == 1) {
                    map.remove(nums[index]);
                } else {
                    map.put(nums[index], count - 1);
                }
            }
        }
        return res;
    }
}
