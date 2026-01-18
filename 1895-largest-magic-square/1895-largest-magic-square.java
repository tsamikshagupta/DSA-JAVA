class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        long[][] rowPref = new long[m][n + 1];
        long[][] colPref = new long[n][m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPref[i][j + 1] = rowPref[i][j] + grid[i][j];
                colPref[j][i + 1] = colPref[j][i] + grid[i][j];
            }
        }
        long[][] diag1 = new long[m + 1][n + 1];
        long[][] diag2 = new long[m + 1][n + 1];
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                diag2[i + 1][j] = diag2[i][j + 1] + grid[i][j];
            }
        }
         int maxSize = Math.min(m, n);

        for (int k = maxSize; k >= 2; k--) {
            for (int r = 0; r + k <= m; r++) {
                for (int c = 0; c + k <= n; c++) {

                    long target = rowPref[r][c + k] - rowPref[r][c];

                    long d1 = diag1[r + k][c + k] - diag1[r][c];
                    long d2 = diag2[r + k][c] - diag2[r][c + k];
                    if (d1 != target || d2 != target) continue;

                    boolean valid = true;

                    for (int i = r; i < r + k && valid; i++) {
                        if (rowPref[i][c + k] - rowPref[i][c] != target)
                            valid = false;
                    }
                    for (int j = c; j < c + k && valid; j++) {
                        if (colPref[j][r + k] - colPref[j][r] != target)
                            valid = false;
                    }

                    if (valid) return k;
                }
            }
        }
        return 1;
        
    }
}