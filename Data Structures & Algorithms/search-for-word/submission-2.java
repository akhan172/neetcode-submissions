class Solution {
    private boolean solve(int i, int j, int cnt, char[][] board, String word) {
        if (cnt == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        
        char ch = board[i][j];
        boolean flag=false;
        if (ch == word.charAt(cnt)) {
            cnt++;
            board[i][j] = '@';
            flag = solve(i - 1, j, cnt, board, word) || solve(i, j - 1, cnt, board, word)
                || solve(i + 1, j, cnt, board, word) || solve(i, j + 1, cnt, board, word);
        }
        board[i][j] = ch;
        return flag;
    }
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (solve(i, j, 0, board, word))
                    return true;
            }
        }
        return false;
    }
}
