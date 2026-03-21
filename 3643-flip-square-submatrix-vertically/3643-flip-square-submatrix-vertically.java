class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            int top = x + i;
            int bottom = x + k - 1 - i;
            for (int j = 0; j < k; j++) {
                int col = y + j;
                int temp = grid[top][col];
                grid[top][col] = grid[bottom][col];
                grid[bottom][col] = temp;
            }
        }
        return grid;
    }
}