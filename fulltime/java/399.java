class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        if (queries.size() == 0) return res;
        Map<String, Set<String>> edges = new HashMap<>();
        Map<String, Double> pathValues = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if (!edges.containsKey(a)) {
                edges.put(a, new HashSet<String>());
            }
            if (!edges.containsKey(b)) {
                edges.put(b, new HashSet<String>());
            }
            edges.get(a).add(b);
            edges.get(b).add(a);
            pathValues.put(a + " " + b, values[i]);
            pathValues.put(b + " " + a, 1.0 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Set<String> visited = new HashSet<>();
            String a = query.get(0), b = query.get(1);
            double ans;
            if (!edges.containsKey(a) || !edges.containsKey(b)) {
                ans = -1.0;
            } else {
                visited.add(a);
                ans = find(a, b, edges, pathValues, visited, 1.0);
            }
            res[i] = ans;
        }
        return res;
    }

    private double find(String s,
                     String e,
                     Map<String, Set<String>> edges,
                     Map<String, Double> pathValues,
                     Set<String> visited,
                     double cur) {
        if (s.equals(e)) {
            return cur;
        }
        Set<String> nexts = edges.get(s);
        if (nexts == null) return -1.0;
        for (String next : nexts) {
            if (!visited.contains(next)) {
                double v = pathValues.get(s + " " + next);
                visited.add(next);
                double ans = find(next, e, edges, pathValues, visited, cur * v);
                visited.remove(next);
                if (ans != -1.0) return ans;
            }
        }
        return -1.0;
    }
}
