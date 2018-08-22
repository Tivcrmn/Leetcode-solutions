class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int max = 0;
        int mid = 0;
        int left = -1;
        int right = -1;
        int[] midSumIndex = new int[nums.length];
        int[] sum = new int[nums.length];
        int[] leftIndex = new int[nums.length];
        int[] leftMax = new int[nums.length];
        int[] rightIndex = new int[nums.length];
        int[] rightMax = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum[i] = i == 0 ? nums[0] : sum[i - 1] + nums[i];
        }
        for (int i = k; i + 2 * k  - 1 < nums.length; i++) {
            midSumIndex[i] = sum[i + k - 1] - sum[i - 1];
        }
        for (int i = k - 1; i + 2 * k < nums.length; i++) {
            if (i == k - 1) {
                leftIndex[i] = k - 1;
                leftMax[i] = sum[k - 1];
            } else {
                if (sum[i] - sum[i - k] > leftMax[i - 1]) {
                    leftIndex[i] = i;
                    leftMax[i] = sum[i] - sum[i - k];
                } else {
                    leftIndex[i] = leftIndex[i - 1];
                    leftMax[i] = leftMax[i - 1];
                }
            }
        }
        for (int i = nums.length - k; i - 2 * k >= 0; i--) {
            if (i == nums.length - k) {
                rightIndex[i] = nums.length - k;
                rightMax[i] = sum[nums.length - 1] - sum[nums.length - k - 1];
            } else {
                if (sum[i + k - 1] - sum[i - 1] > rightMax[i + 1]) {
                    rightIndex[i] = i;
                    rightMax[i] = sum[i + k - 1] - sum[i - 1];
                } else {
                    rightIndex[i] = rightIndex[i + 1];
                    rightMax[i] = rightMax[i + 1];
                }
            }
        }
        for (int i = k; i + 2 * k - 1 < nums.length; i++) {
            if (midSumIndex[i] + leftMax[i - 1] + rightMax[i + k] > max) {
                mid = i;
                left = leftIndex[i - 1] - k + 1;
                right = rightIndex[i + k];
                max = midSumIndex[i] + leftMax[i - 1] + rightMax[i + k];
            }
        }
        return new int[]{left, mid, right};
    }
}
