class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int c = colStart; c <= colEnd; c++) {
                matrix[rowStart][c] = num++;
            }
            rowStart++;
            for (int r = rowStart; r <= rowEnd; r++) {
                matrix[r][colEnd] = num++;
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int c = colEnd; c >= colStart; c--) {
                    matrix[rowEnd][c] = num++;
                }
            }
            rowEnd--;
            if (colStart <= colEnd) {
                for (int r = rowEnd; r >= rowStart; r--) {
                    matrix[r][colStart] = num++;
                }
            }
            colStart++;
        }
        return matrix;
    }
}