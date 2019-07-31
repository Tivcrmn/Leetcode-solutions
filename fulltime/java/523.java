class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int p = k == 0 ? sum : sum % k;
            Integer index = map.get(p);
            if (index != null) {
                if (i - index >= 2) return true;
            } else {
                map.put(p, i);
            }
        }
        return false;
    }
}
