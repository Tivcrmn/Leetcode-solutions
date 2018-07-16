// not working. sad......
class Solution {
    public String removeDuplicateLetters(String s) {
        List<Integer>[] map = new ArrayList[26];
        StringBuilder selected = new StringBuilder();
        int[] pos = new int[26];
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (map[index] == null) {
                map[index] = new ArrayList<>();
                map[index].add(i);
            } else {
                map[index].add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Character> reverse = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (map[i] != null && map[i].size() == 1) {
                list.add(map[i].get(0));
                reverse.put(map[i].get(0), (char)(i + 97));
                pos[i] = map[i].get(0);
            }
        }
        for (int a : pos) {
            System.out.print(a + " ");
        }
        Collections.sort(list);
        for (int item : list) {
            selected.append(reverse.get(item));
        }
        System.out.println(map.get('g'));
        System.out.println(selected.toString());
        for (int i = 0; i < 26; i++) {
            if (map[i] != null && map[i].size() > 1) {
                int count = 0;
                while (count < selected.length() &&
                       selected.toString().charAt(count) - 'a' < i) {
                    for (int cur : map[i]) {
                        if (cur > pos[count]) {
                            while (count < selected.length() && pos[selected.toString().charAt(count) - 'a'] < cur) {
                                count++;
                            }
                            System.out.println((char)(i + 97) + " " + count + " " + i + " " + cur);
                            selected.insert(count, (char)(i + 97));
                            pos[i] = cur;
                            System.out.println(selected.toString());
                            count = selected.length();
                            break;
                        }
                    }
                    count++;
                }


            }
        }
        return selected.toString();
    }
}
