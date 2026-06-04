class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root);
            }
        }
        return result;
    }
    private void dfs(char[][] board, int r, int c, TrieNode node) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }
        char ch = board[r][c];
        if (ch == '#') {
            return;
        }
        TrieNode next = node.children[ch - 'a'];
        if (next == null) {
            return;
        }
        if (next.word != null) {
            result.add(next.word);
            next.word = null; 
        }
        board[r][c] = '#';
        dfs(board, r + 1, c, next);
        dfs(board, r - 1, c, next);
        dfs(board, r, c + 1, next);
        dfs(board, r, c - 1, next);
        board[r][c] = ch;
    }
}