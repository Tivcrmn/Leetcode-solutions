class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, root, board, res);
            }
        }
        return res;
    }

    private void dfs(int i,
                     int j,
                     TrieNode node,
                     char[][] board,
                     List<String> res) {
        char c = board[i][j];
        if (board[i][j] == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(i - 1, j, node, board, res);
        if (j > 0) dfs(i, j - 1, node, board, res);
        if (i < board.length - 1) dfs(i + 1, j, node, board, res);
        if (j < board[0].length - 1) dfs(i, j + 1, node, board, res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new TrieNode();
                cur = cur.children[i];
            }
            cur.word = word;
        }
        return root;
    }
}
