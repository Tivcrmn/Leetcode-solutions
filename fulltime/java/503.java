class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length * 2];
        if (nums.length == 0) return res;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int cur = nums[i % nums.length];
            while (!st.isEmpty() && nums[st.peek() % nums.length] < cur) {
                res[st.pop()] = cur;
            }
            st.push(i);
        }
        while (!st.isEmpty()) res[st.pop()] = -1;
        return Arrays.copyOfRange(res, 0, nums.length);
    }
}
