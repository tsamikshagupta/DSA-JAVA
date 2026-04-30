class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int cost = 0; cost <= k; cost++) {
                    if (dp[i][j][cost] == -1) continue;
                    if (j + 1 < n) {
                        int newc = cost + (grid[i][j + 1] == 0 ? 0 : 1);
                        if (newc <= k) {
                            dp[i][j + 1][newc] = Math.max(
                                dp[i][j + 1][newc],
                                dp[i][j][cost] + grid[i][j + 1]
                            );
                        }
                    }
                    if (i + 1 < m) {
                        int newc = cost + (grid[i + 1][j] == 0 ? 0 : 1);
                        if (newc <= k) {
                            dp[i + 1][j][newc] = Math.max(
                                dp[i + 1][j][newc],
                                dp[i][j][cost] + grid[i + 1][j]
                            );
                        }
                    }
                }
            }
        }
        int ans = -1;
        for (int cost = 0; cost <= k; cost++) {
            ans = Math.max(ans, dp[m - 1][n - 1][cost]);
        }

        return ans;
    }
}