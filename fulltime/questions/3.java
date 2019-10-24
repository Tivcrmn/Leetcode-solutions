class Solution {
  static private int process(int N) {
    int max = 0;
    Map<Integer, Integer> steps = new HashMap<>();
    steps.put(1, 0);
    for (int i = 2; i <= N; i++) {
      if (!steps.containsKey(i)) steps.put(i, find(i, steps));
      max = Math.max(max, steps.get(i));
    }
    return max;
  }

  static private int find(int num, Map<Integer, Integer> steps) {
    if (steps.containsKey(num)) return steps.get(num);
    int n = num % 2 == 0 ? num / 2 : num * 3 + 1;
    int step = 1 + find(n, steps);
    steps.put(num, step);
    return step;
  }

  public static void main(String[] args) {
    System.out.println(process(5));
  }
}
