class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0 ; i < rows; i++){
            dfs(board , i ,0);
            dfs(board , i , cols - 1);

        }
        for(int j = 0 ; j < cols ; j++){
            dfs(board , 0 , j);
            dfs(board , rows - 1, j);
        }
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    private void dfs(char[][] board , int r , int c){
        int rows = board.length;
        int cols = board[0].length;
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O') {
            return;
        }
        board[r][c] = '#';
        dfs(board , r + 1 , c);
        dfs(board , r - 1, c);
        dfs(board , r , c + 1);
        dfs(board , r , c - 1);
    }
}