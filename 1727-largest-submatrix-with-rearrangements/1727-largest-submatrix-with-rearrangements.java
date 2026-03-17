class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && i > 0)
                    matrix[i][j] += matrix[i - 1][j];
            }
            int[] row = matrix[i].clone();
            Arrays.sort(row);
            for (int j = n - 1; j >= 0; j--) {
                ans = Math.max(ans, row[j] * (n - j));
            }
        }

        return ans;
    }
}