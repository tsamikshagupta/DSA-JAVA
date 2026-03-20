class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        set.add(grid[x][y]);
                    }
                }
                if (set.size() <= 1) {
                    ans[i][j] = 0;
                    continue;
                }

                int minDiff = Integer.MAX_VALUE;
                Integer prev = null;
                for (int val : set) {
                    if (prev != null) {
                        minDiff = Math.min(minDiff, val - prev);
                    }
                    prev = val;
                }

                ans[i][j] = minDiff;
            }
        }
        return ans;
    }
}