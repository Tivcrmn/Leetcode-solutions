# Two Sum

## Description

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

**Example:**

Input: [3,4,5,1,2]
Output: 1

Input: [4,5,6,7,0,1,2]
Output: 0

## Solution

```java
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) start = mid;
            else if (nums[mid] < nums[start] && nums[mid] < nums[end]) end = mid;
        }
        return nums[start] > nums[end] ? nums[end] : nums[start];
    }
}
```

## Thinking

### O(n)

The easiest way is to use a variable maybe named min, which is a Integer, to store the min value in the array when we iterate the whole array. So the time complexity is O(n).

### O(logn)

There are two kinds of cases in this problem. First is that that the array is not rotated, so this is ascending. And the other case is like the example. So we can still use the middle index of start and end to exclude some element. In the first case, there are two branches left and right, all the elements in the left branch are bigger than right branch, so we just need to judge whether the middle element is in the left branch or not. For example, if the middle index is in the left branch, so nums[mid] is bigger than nums[start] and nums[end], so we can just change start index to middle index, the same as right index. In the not rotated case, the nums[mid] is larger than nums[start] but smaller than nums[end], so we can change end index to middle index. And in order we can set the continue condition to start + 1 < end, which means if two elements are neighbor, we break out from the while loop. And we know that the smaller one of nums[start] and nums[end] is the answer.
