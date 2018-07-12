class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int preSum = 0;
        Map<Integer, List<Integer>> prefixSum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSum - k == 0) {
                res += 1;
            }
            if (prefixSum.get(preSum - k) != null) {
                res += prefixSum.get(preSum - k).size();
            }
            if (prefixSum.get(preSum) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                prefixSum.put(preSum, list);
            } else {
                prefixSum.get(preSum).add(i);
            }
        }
        return res;
    }
}
