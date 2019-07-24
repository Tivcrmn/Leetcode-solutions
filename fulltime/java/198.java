class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] r = new int[n];
        int[] nr = new int[n];
        r[0] = nums[0];
        for (int i = 1; i < n; i++) {
            r[i] = nr[i - 1] + nums[i];
            nr[i] = Math.max(r[i - 1], nr[i - 1]);
        }
        return Math.max(r[n - 1], nr[n - 1]);
    }
}
