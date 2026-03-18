class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] pref = new long[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long up = (i > 0) ? pref[i - 1][j] : 0;
                long left = (j > 0) ? pref[i][j - 1] : 0;
                long diag = (i > 0 && j > 0) ? pref[i - 1][j - 1] : 0;

                pref[i][j] = grid[i][j] + up + left - diag;
                if (pref[i][j] <= k) {
                    count++;
                }
            }
        }

        return count;
        
    }
}