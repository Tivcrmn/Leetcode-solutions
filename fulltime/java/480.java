class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        double[] res = new double[len];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            // add the number
            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else minHeap.add(nums[i]);

            // balance two heaps
            if (minHeap.size() > maxHeap.size()) {
                // minHeap.size - maxHeap.size == 1 or 2
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                // maxHeap.size - minHeap.size == 2
                minHeap.add(maxHeap.poll());
            }

            if (i >= k - 1) {
                double median = 0;
                if (k % 2 == 1) {
                    median = maxHeap.peek();
                } else {
                    median = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                }
                res[i - k + 1] = median;
                // remove the nums[i - k + 1]
                int removeNum = nums[i - k + 1];
                if (removeNum <= maxHeap.peek()) {
                    maxHeap.remove(removeNum);
                } else {
                    minHeap.remove(removeNum);
                }

                // balance two heaps again
                if (minHeap.size() > maxHeap.size()) {
                    // minHeap.size - maxHeap.size == 1 or 2
                    maxHeap.add(minHeap.poll());
                } else if (maxHeap.size() > minHeap.size() + 1) {
                    // maxHeap.size - minHeap.size == 2
                    minHeap.add(maxHeap.poll());
                }
            }
        }
        return res;
    }
}
