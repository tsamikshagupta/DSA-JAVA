class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int NEG_INF = -1000000000;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = NEG_INF;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int product = nums1[i - 1] * nums2[j - 1];
                int take = product + Math.max(0, dp[i - 1][j - 1]);
                int skip1 = dp[i - 1][j];
                int skip2 = dp[i][j - 1];
                dp[i][j] = Math.max(take, Math.max(skip1, skip2));
            }
        }
        return dp[n][m];
        
    }
}