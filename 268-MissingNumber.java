class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res;
    }
}
