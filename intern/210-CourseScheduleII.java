class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[]{};
        }

        HashMap <Integer, Integer> indegree = new HashMap<>();
        HashMap <Integer, LinkedList<Integer>> outdegree = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        int[] res = new int[numCourses];

        // initialize the indegree hashmap
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
        }

        // initialize the outdegree hashmap
        for (int i = 0; i < numCourses; i++) {
            outdegree.put(i, new LinkedList<Integer>());
        }

        // get indegree
        indegree = getindegree(indegree, prerequisites);

        // get outdegree
        outdegree = getoutdegree(outdegree, prerequisites);

        for (int i = 0; i < numCourses; i++) {
            int nextCoursesNum = indegree.get(i);
            if (nextCoursesNum == 0) {
                queue.offer(i);
                result.add(i);
                System.out.println(i);
            }
        }
        while (!queue.isEmpty()) {
            int courseNum = queue.poll();
            LinkedList<Integer> nextCouses = outdegree.get(courseNum);
            for (Integer course : nextCouses) {
                indegree.put(course, indegree.get(course) - 1);
                if (indegree.get(course) == 0) {
                    queue.offer(course);
                    result.add(course);
                    System.out.println(course);
                }
            }
        }
        if (result.size() == numCourses) {
            for (int i = 0; i < result.size(); i++) {
                res[i] = result.get(i);
            }
            return res;
        }

        return new int[]{};
    }

    private HashMap<Integer, Integer> getindegree(HashMap <Integer, Integer> indegree, int[][] prerequisites) {
        for (int[] preq : prerequisites) {
            indegree.put(preq[0], indegree.get(preq[0]) + 1);
        }
        return indegree;
    }

    private HashMap<Integer, LinkedList<Integer>> getoutdegree(HashMap <Integer, LinkedList<Integer>> outdegree, int[][] prerequisites) {
        for (int[] preq : prerequisites) {
            LinkedList<Integer> courses = outdegree.get(preq[1]);
            courses.add(preq[0]);
            outdegree.put(preq[1], courses);
        }
        return outdegree;
    }
}
