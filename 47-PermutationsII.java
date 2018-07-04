class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, new ArrayList<Integer>(), visited, results);

        return results;
    }

    private void helper(int[] nums,
                        List<Integer> permutation,
                        boolean[] visited,
                        List<List<Integer>> results) {
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            helper(nums, permutation, visited, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}
