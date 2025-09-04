class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 ) return 0;
        int[][] memo = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n ; j++){
                memo[i][j] = -1;
            }
        }
        return dfs(0,0,m,n,obstacleGrid,memo);
        
    }
    private int dfs(int i, int j, int m, int n, int[][] grid, int[][] memo){
        if(i>=m || j>=n || grid[i][j] == 1) return 0;
        if(i== m-1 && j==n-1) return 1;
        if(memo[i][j] != -1) return memo[i][j];

        int right = dfs(i , j+1, m ,n , grid, memo);
        int down = dfs(i+1, j , m ,n , grid, memo);

        memo[i][j] = right + down;
        return memo[i][j];
    }
}