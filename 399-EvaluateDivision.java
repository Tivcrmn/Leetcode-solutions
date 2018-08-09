class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        if (equations == null || values == null || equations.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, List<String>> neighbors = new HashMap();
        Set<String> nodes = new HashSet<>();
        for (int i = 0; i < equations.length; i++) {
            String n1 = equations[i][0];
            String n2 = equations[i][1];
            map.put(n1 + " " + n2, i);
            if (!nodes.contains(n1)) nodes.add(n1);
            if (!nodes.contains(n2)) nodes.add(n2);
            List<String> nb1 = neighbors.get(n1);
            List<String> nb2 = neighbors.get(n2);
            if (nb1 == null) {
                nb1 = new ArrayList<String>();
                nb1.add(n2);
                neighbors.put(n1, nb1);
            } else {
                nb1.add(n2);
            }
            if (nb2 == null) {
                nb2 = new ArrayList<String>();
                nb2.add(n1);
                neighbors.put(n2, nb2);
            } else {
                nb2.add(n1);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (!nodes.contains(queries[i][0]) || !nodes.contains(queries[i][1])) res[i] = -1.0;
            else if (queries[i][0].equals(queries[i][1])) res[i] = 1.0;
            else res[i] = getAnswer(queries[i][0], queries[i][1], map, neighbors, new HashSet<String>(nodes), values, 1.0);
        }
        return res;
    }

    private double getAnswer(String num1,
                             String num2,
                             HashMap<String, Integer> map,
                             HashMap<String, List<String>> neighbors,
                             Set<String> nodes,
                             double[] values,
                             double res) {
        if (num1.equals(num2)) return res;
        for (String neighbor : neighbors.get(num1)) {
            if (!nodes.contains(num1)) continue;
            nodes.remove(num1);
            Integer v = map.get(num1 + " " + neighbor);
            double d = 0;
            if (v == null) d = 1 / values[map.get(neighbor + " " + num1)];
            else d = values[v];
            double ans = getAnswer(neighbor,
                                     num2,
                                     map,
                                     neighbors,
                                     nodes,
                                     values,
                                     res * d);
            if (ans != -1.0) return ans;
            nodes.add(num1);
        }
        return -1.0;
    }
}
