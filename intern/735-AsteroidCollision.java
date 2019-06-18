class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) return asteroids;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (s.isEmpty() ||
                s.peek() < 0 && asteroids[i] < 0 ||
                s.peek() > 0 && asteroids[i] > 0 ||
                s.peek() < 0 && asteroids[i] > 0) s.push(asteroids[i]);
            if (s.peek() > 0 && asteroids[i] < 0) {
                if (s.peek() > -asteroids[i]) continue;
                else if (s.peek() == -asteroids[i]) s.pop();
                else {
                    s.pop();
                    i--;
                }
            }
        }
        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}
