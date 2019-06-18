class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if (nums == null || nums.length < 2) return new ArrayList<List<Integer>>();
        helper(nums, 0, new ArrayList<Integer>(), set);
        return new ArrayList<List<Integer>>(set);
    }

    private void helper(int[] nums,
                        int index,
                        List<Integer> ans,
                        Set<List<Integer>> set) {
        if (index == nums.length) {
            if (ans.size() >= 2 && !set.contains(ans)) set.add(new ArrayList<Integer>(ans));
        } else {
            if (ans.size() == 0 || ans.get(ans.size() - 1) <= nums[index]) {
                helper(nums, index + 1, new ArrayList<Integer>(ans), set);
                ans.add(nums[index]);
                helper(nums, index + 1, new ArrayList<Integer>(ans), set);
            } else {
                helper(nums, index + 1, new ArrayList<Integer>(ans), set);
            }
        }
    }
}
