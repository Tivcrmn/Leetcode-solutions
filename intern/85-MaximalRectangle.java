class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] trans = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') trans[j] = 0;
                else trans[j] += matrix[i][j] - '0';
            }
            max = Math.max(max, helper(trans));
        }
        return max;
    }

    private int helper(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) s.push(i);
            else {
                int curMin = s.pop();
                maxArea = Math.max(maxArea, heights[curMin] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
