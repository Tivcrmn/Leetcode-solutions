class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int p = nums.length - 2;
        while (p >= 0) {
            if (nums[p] < nums[p + 1]) {
                int minIndex = nums.length - 1;
                while (nums[minIndex] <= nums[p]) {
                    minIndex--;
                }
                int temp = nums[p];
                nums[p] = nums[minIndex];
                nums[minIndex] = temp;
                for (int i = 0; i < (nums.length - p - 1) / 2; i++) {
                    int tmp = nums[i + p + 1];
                    nums[i + p + 1] = nums[nums.length - 1 - i];
                    nums[nums.length - 1 - i] = tmp;
                }
                return;
            } else {
                p--;
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}
