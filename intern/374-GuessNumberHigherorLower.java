/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res == -1) end = mid;
            else if (res == 1) start = mid;
        }
        if (guess(start) == 0) return start;
        return end;
    }
}
