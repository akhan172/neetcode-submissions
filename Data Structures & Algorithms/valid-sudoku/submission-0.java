class Solution {
    private boolean traverse(char[][] board, int sr, int sc, int er, int ec){
        Set<Character> st = new HashSet<>();
        for(int i=sr; i<=er; i++){
            for(int j=sc; j<=ec; j++){
                if(Character.isDigit(board[i][j])&& !st.add(board[i][j])){
                    return false;
                }
                else if(Character.isDigit(board[i][j])){
                    st.add(board[i][j]);
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            Set<Character> st = new HashSet<>();
            for(int j=0; j<9; j++){
                if(Character.isDigit(board[i][j])&& !st.add(board[i][j])){
                    return false;
                }
                else if(Character.isDigit(board[i][j])){
                    st.add(board[i][j]);
                }
            }
        }
        for(int i=0; i<9; i++){
            Set<Character> st = new HashSet<>();
            for(int j=0; j<9; j++){
                if(Character.isDigit(board[j][i])&& !st.add(board[j][i])){
                    return false;
                }
                else if(Character.isDigit(board[j][i])){
                    st.add(board[j][i]);
                }
            }
        }

        for(int i = 0; i<9; i+=3){
            int er = i+2;
            for(int j=0; j<9; j+=3){
                int ec = j + 2;
                if(!traverse(board, i, j, er, ec))
                    return false;
            }
        }
        return true;
    }
}
