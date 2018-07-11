class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int total = 0;
        int left = 1;
        int right = height.length - 2;
        int leftmax = height[0], rightmax = height[height.length - 1];
        while (left <= right) {
            if (leftmax <= rightmax) {
                total += Math.max(0, leftmax - height[left]);
                leftmax = Math.max(height[left], leftmax);
                left++;
            } else {
                total += Math.max(0, rightmax - height[right]);
                rightmax = Math.max(height[right], rightmax);
                right--;
            }
        }
        return total;
    }
}
