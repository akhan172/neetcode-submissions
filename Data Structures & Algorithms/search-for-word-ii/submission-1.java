class Solution {
    // first setup trie
    class Tnode {
        // child
        Tnode[] child = new Tnode[26];
        // String instead of bool
        String word;
    }
    // root
    private Tnode root;
    // insert function
    private void insert(String word) {
        Tnode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Tnode();
            }
            curr = curr.child[idx];
        }
        curr.word = word;
    }
    public List<String> findWords(char[][] board, String[] words) {
        // setting up and filling the trie
        root = new Tnode();
        for (String w : words) {
            insert(w);
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, root, res);
            }
        }
        return res;
    }
    // Writing DFS
    private void dfs(int i, int j, char[][] board, Tnode root, List<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        char ch = board[i][j];
        if (ch == '#') {
            return;
        }

        Tnode next = root.child[ch - 'a'];

        if (next == null) {
            return;
        }
        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }
        board[i][j] = '#';

        dfs(i+1, j, board, next, res);
        dfs(i-1, j, board, next, res);
        dfs(i, j+1, board, next, res);
        dfs(i, j-1, board, next, res);
        board[i][j] =ch;
    }
}
