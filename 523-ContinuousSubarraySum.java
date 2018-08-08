class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) return true;
            }
            return false;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i == 0 ? 0 : nums[i - 1];
            if (i > 0 && nums[i] % k == 0) return true;
            else {
                List<Integer> rs = map.get(nums[i] % k);
                if (rs != null) {
                    for (int ri : rs) {
                        if (i - ri > 1) return true;
                    }
                } else {
                    rs = new ArrayList<Integer>();
                    rs.add(i);
                    map.put(nums[i] % k, rs);
                }
            }
        }
        return false;
    }
}
