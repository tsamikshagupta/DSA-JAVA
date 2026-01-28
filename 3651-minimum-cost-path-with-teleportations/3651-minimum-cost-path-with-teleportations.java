class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int INF = 1_000_000_000;
        int maxV = 0;
        for (int[] row : grid) for (int v : row) maxV = Math.max(maxV, v);

        ArrayList<int[]>[] buckets = new ArrayList[maxV + 1];
        for (int v = 0; v <= maxV; v++) buckets[v] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                buckets[grid[i][j]].add(new int[]{i, j});
            }
        }

        int[][][] dp = new int[k + 1][m][n];
        for (int t = 0; t <= k; t++) {
            for (int i = 0; i < m; i++) Arrays.fill(dp[t][i], INF);
        }
        dp[0][0][0] = 0;

        for (int t = 0; t <= k; t++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cur = dp[t][i][j];
                    if (cur >= INF) continue;

                    if (i + 1 < m) dp[t][i + 1][j] = Math.min(dp[t][i + 1][j], cur + grid[i + 1][j]);
                    if (j + 1 < n) dp[t][i][j + 1] = Math.min(dp[t][i][j + 1], cur + grid[i][j + 1]);
                }
            }

            if (t == k) break;

            int best = INF;
            for (int v = maxV; v >= 0; v--) {
                for (int[] pos : buckets[v]) {
                    best = Math.min(best, dp[t][pos[0]][pos[1]]);
                }
                if (best < INF) {
                    for (int[] pos : buckets[v]) {
                        int i = pos[0], j = pos[1];
                        if (best < dp[t + 1][i][j]) dp[t + 1][i][j] = best;
                    }
                }
            }
        }

        int ans = INF;
        for (int t = 0; t <= k; t++) ans = Math.min(ans, dp[t][m - 1][n - 1]);
        return ans;
    }
}
