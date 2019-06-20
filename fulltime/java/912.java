class Solution {
    // bubble sort TLE :(
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, j + 1, nums);
                }
            }
        }
        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution {
    // insertion sort pass:) 5.02%
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[j + 1] < nums[j]) {
                    swap(j, j + 1, nums);
                } else break;
            }
        }
        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution {
    // selection sort pass:) 5.02%
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int localMin = 50001;
            int localMinIndex = -1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < localMin) {
                    localMin = nums[j];
                    localMinIndex = j;
                }
            }
            if (localMinIndex != i) swap(localMinIndex, i, nums);
        }
        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        // shell sort pass:) 49.76%
        int gap = nums.length / 2;
        while (gap >= 1) {
            for (int i = 0; i < gap; i++) {
                for (int j = i; j < nums.length; j += gap) {
                    for (int k = j; k - gap >= 0; k-= gap) {
                        if (nums[k] < nums[k - gap]) {
                            swap(k, k - gap, nums);
                        } else break;
                    }
                }
            }
            gap /= 2;
        }
        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        // heap sort TLE... check it later.. it should not be TLE
        for (int i = 0; i < nums.length - 1; i++) {
            int lastIndex = nums.length - 1 - i;
            for (int j = lastIndex; j >= 0; j--) {
                bubbleUp(j, nums);
            }
            swap(lastIndex, 0, nums);
        }
        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void bubbleUp(int index, int[] nums) {
        while (true) {
            int parentIndex = (index - 1) / 2;
            if (parentIndex >= 0) {
                if (nums[parentIndex] < nums[index]) {
                    swap(parentIndex, index, nums);
                    index = parentIndex;
                } else return;
            } else return;
        }
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        // merge sort pass:) 39.50%
        return merge(0, nums.length - 1, nums);
    }

    private int[] merge(int l, int r, int[] nums) {
        if (l > r) return new int[]{};
        if (l == r) return new int[]{nums[l]};
        int mi = (l + r) / 2;
        int[] larray = merge(l, mi, nums);
        int[] rarray = merge(mi + 1, r, nums);
        int[] res = new int[larray.length + rarray.length];
        int lp = 0, rp = 0, p = 0;;
        while (lp < larray.length || rp < rarray.length) {
            if (lp >= larray.length) {
                res[p++] = rarray[rp++];
            } else if (rp >= rarray.length) {
                res[p++] = larray[lp++];
            } else {
                res[p++] = larray[lp] <= rarray[rp] ? larray[lp++] : rarray[rp++];
            }
        }
        return res;
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        // quick sort pass:) 97.38%
        quickSort(0, nums.length - 1, nums);
        return nums;
    }

    private void quickSort(int start, int end, int[] nums) {
        int index = partition(start, end, nums);
        if (index - 1 > start) {
            quickSort(start, index - 1, nums);
        }
        if (index + 1 < end) {
            quickSort(index + 1, end, nums);
        }
    }

    private int partition(int lo, int hi, int[] nums) {
        int i = lo + 1, j = hi;
        while (i <= j) {
           if (nums[i] <= nums[lo]) {
               i++;
           } else if (nums[j] >= nums[lo]) {
               j--;
           } else {
               swap(i++, j--, nums);
           }
        }
        swap(lo, j, nums);
        return j;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
