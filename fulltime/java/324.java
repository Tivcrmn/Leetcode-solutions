class Solution {
    public void wiggleSort(int[] nums) {
        // It is impossible for me to come up with the follow up
        if (nums == null || nums.length <= 1) return;
        int n = nums.length;
        // m is the first index for the odd part
        int m = (n + 1) / 2; 
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        // fill the even part
        for (int j = 0, i = m - 1; j < nums.length && i >= 0; j += 2) nums[j] = copy[i--];
        // fill the odd part
        for (int j = 1, i = n - 1; j < nums.length && i >= m; j += 2) nums[j] = copy[i--];
    }
}
