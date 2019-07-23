class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return true;
        int reachMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (reachMax >= i) {
                reachMax = Math.max(reachMax, i + nums[i]);
            }
        }
        return reachMax >= nums.length - 1;
    }
}
