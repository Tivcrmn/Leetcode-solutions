```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        int k = 0;
        for (Character task : tasks) {
            freqs[task - 'A']++;
        }
        Arrays.sort(freqs);
        for (int i = 25; i >= 0; i--) {
            if (freqs[i] == freqs[25]) {
                k++;
            } else {
                break;
            }
        }
        return Math.max((n + 1) * (freqs[25] - 1) + k, tasks.length);
    }
}
```

### FB 变种

1. Task 有序，给定 cooldown，需要返回总的执行时间，同时返回执行顺序。
```java
public List<Integer> Printer(String[] tasks, int cooldown) {
    List<Integer> ret = new  LinkedList<Integer>();
    if (tasks == null || tasks.length == 0) {
        return;
    }
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    int j = 0;
    for(int i = 0; i < tasks.length; i++) {
        while (map.containsKey(tasks[i]) && map.get(tasks[i]) + cooldown >= j) {
          ret.add("_");
          j++;
        }
        ret.add(tasks[i]);
        map.put(tasks[i], j);
        j++;
   }
   return ret;
}
```

2. Tasks 类型很多，但是 cooldown 很小。优化空间复杂度到O(cooldown)
这样时间复杂度可能会增加到O(kn)，cooldown长度*task个数，但空间复杂度能够降低。

```java
public  int completionInterval(char tasks[], int n) {
      int time = 0;
      Queue<Character> queue = new LinkedList<Character>();
      for(char c : tasks){
          if(!queue.contains(c)){
              //  exec straightly
              queue.add(c);
              if(queue.size()>n) queue.poll();

          }
          else{
              while(queue.size() <= n) {
                  queue.add('*');
                  time++;
              }
              while(queue.peek()!= c) queue.poll();
              queue.add(c);
          }
          time++;
          System.out.println(time);
      }
      return time;
    }
```
