class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        int i = -1;
        char prev = 'L';
        for (int j = 0; j <= dominoes.length(); j++) {
            char c = j == dominoes.length() ? 'R' : dominoes.charAt(j);
            if (c == '.') continue;
            if (c == 'L' && prev == 'L') {
                replace(sb, i + 1, j - 1, 'L');
            } else if (c == 'R' && prev == 'R') {
                replace(sb, i + 1, j - 1, 'R');
            } else if (c == 'L' && prev == 'R') {
                int num = j - i - 1;
                if (num == 0) {
                    prev = c;
                    continue;
                }
                if (num % 2 == 0) {
                    replace(sb, i + 1, i + num / 2, 'R');
                    replace(sb, i + num / 2 + 1, j - 1, 'L');
                } else {
                    replace(sb, i + 1, i + num / 2, 'R');
                    replace(sb, i + num / 2 + 2, j - 1, 'L');
                }
                prev = 'L';
            } else if (c == 'R' && prev == 'L') {
                prev = 'R';
            }
            i = j;
        }
        return sb.toString();
    }

    private void replace(StringBuilder sb, int i, int j, char c) {
        while (i <= j) {
            sb.setCharAt(i++, c);
        }
    }
}
