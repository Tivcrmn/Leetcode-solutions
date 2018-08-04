class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (true) {
            while (i < nums.length && nums[i] != 0) i++;
            j = i;
            while (j < nums.length && nums[j] == 0) j++;
            if (i < nums.length && j < nums.length) swap(i, j, nums);
            else break;
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
