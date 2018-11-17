# First Bad Version

## Description

There is a project which failed to build in the end. We need to find the first bad version. And the version after the first bad version is all bad.

We can use API bool isBadVersion(version) to judge whether the given version n is bad or not. Our goal is to find the first bad version and minimize the times we call the API.

**Example:**

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.

## Solution

```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
```

## Thinking

So we can think this problem in this way. There is an array, and all the elements are seperated into true and bad. And all the true elements are before the bad elements. So we need to find the first bad element.

### O(n)

The easiest way is to iterate every element and find the first bad version. And return. That is not what we want.

### O(logn)

We can use binary search. Because we can use the API seperate the versions easily. we know the start version index is 1, and the end version index is n. So we can get the middle of the index, call API with the middle index. If the middle index version is true, so the versions before the middle index are all true, so we move the start index to middle + 1, if middle index version is bad, so the first bad version might be the middle index or before it, so we change end index to middle. In order to do it repeatly, we need to do it in a while loop, and finally, the start index will equals to end index, so the while loop condition can be start index is smaller than end index. When we break from the while loop, the start index is euqals to end index, we can return one of them is OK.
