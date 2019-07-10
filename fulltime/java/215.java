class Solution {
    public int findKthLargest(int[] nums, int k) {
        // O(nlogn) average
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // O(nlogk)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

class Solution {
    // O(n) average
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (true) {
            int pos = partition(lo, hi, nums);
            if (pos == index) return nums[index];
            else if (pos < index) lo = pos + 1;
            else hi = pos - 1;
        }
    }

    private int partition(int start, int end, int[] nums) {
        int lo = start + 1, hi = end;
        while (lo <= hi) {
            if (nums[lo] <= nums[start]) lo++;
            else if (nums[hi] >= nums[start]) hi--;
            else swap(lo++, hi--, nums);
        }
        swap(start, hi, nums);
        return hi;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
