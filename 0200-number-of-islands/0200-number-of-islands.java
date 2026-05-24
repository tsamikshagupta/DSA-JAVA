class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid , i , j);
                }
            }
        }
        return count;

    }
    private void dfs(char[][] grid, int row , int col){
        int rs = grid.length;
        int cs = grid[0].length;
        if (row < 0 || col < 0 || row >= rs || col >= cs || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid , row + 1 , col);
        dfs(grid , row - 1, col);
        dfs(grid , row , col + 1);
        dfs(grid, row , col - 1);
    }
}