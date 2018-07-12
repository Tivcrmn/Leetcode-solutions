class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            twoSum(left, right, target, nums, results);
        }

        return results;
    }

    private void twoSum(int left,
                        int right,
                        int target,
                        int[] nums,
                        List<List<Integer>> results) {
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(-target);
                result.add(nums[left]);
                result.add(nums[right]);
                results.add(result);
                left++;
                right--;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
