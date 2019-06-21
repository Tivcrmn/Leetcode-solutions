class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            digits.add(x % 10);
            x = x / 10;
        }
        int l = 0, r = digits.size() - 1;
        while (l < r) {
            if (digits.get(l) == digits.get(r)) {
                l++;
                r--;
            } else return false;
        }
        return true;
    }
}
