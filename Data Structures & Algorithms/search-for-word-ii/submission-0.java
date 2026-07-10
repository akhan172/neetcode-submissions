class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (curr.child[idx] == null) {
                    curr.child[idx] = new TrieNode();
                }

                curr = curr.child[idx];
            }

            curr.word = word;
        }

        List<String> ans = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> ans) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char ch = board[i][j];

        if (ch == '#')
            return;

        TrieNode next = node.child[ch - 'a'];

        if (next == null)
            return;

        // Word found
        if (next.word != null) {
            ans.add(next.word);
            next.word = null; // Avoid duplicates
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, next, ans);
        dfs(board, i - 1, j, next, ans);
        dfs(board, i, j + 1, next, ans);
        dfs(board, i, j - 1, next, ans);

        board[i][j] = ch;
    }
}