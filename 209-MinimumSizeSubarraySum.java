class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (i < nums.length) {
            if (sum < s) {
                if (j < nums.length) {
                    sum += nums[j];
                    j++;
                } else break;
            } else {
                while (sum >= s) {
                    sum -= nums[i];
                    i++;
                }
                minLength = Math.min(j - i + 1, minLength);
                j = i;
                sum = 0;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
