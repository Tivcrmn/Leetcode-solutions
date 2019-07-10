class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int i = A.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (A[maxIndex] <= A[j]) {
                    maxIndex = j;
                }
            }
            if (maxIndex == i) continue;
            res.add(maxIndex + 1);
            res.add(i + 1);
            reverse(A, 0, maxIndex);
            reverse(A, 0, i);
        }
        return res;
    }

    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
    }
}
