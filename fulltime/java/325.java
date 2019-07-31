class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer index = map.get(sum - k);
            if (index != null) max = Math.max(max, i - index);
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
