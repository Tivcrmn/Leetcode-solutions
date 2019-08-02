class Solution {
    public int sumSubarrayMins(int[] A) {
        // So tricky....
        int[] right = new int[A.length];
        int[] left = new int[A.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                right[stack.pop()] = i - 1;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            right[stack.pop()] = A.length - 1;
        }
        stack = new Stack();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
                left[stack.pop()] = i + 1;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            left[stack.pop()] = 0;
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int leftsize = i - left[i] + 1;
            int rightsize = right[i] - i + 1;
            sum = (sum + A[i] * leftsize * rightsize) % 1_000_000_007;
        }
        return sum;
    }
}
