class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        long maxDiagonalSquared = 0;
        int maxArea = 0;
        for (int[] dim : dimensions) {
            int length = dim[0];
            int width = dim[1];
            long diagonalSquared = (long) length * length + (long) width * width;
            int area = length * width;
            if (diagonalSquared > maxDiagonalSquared) {
                maxDiagonalSquared = diagonalSquared;
                maxArea = area;
            } else if (diagonalSquared == maxDiagonalSquared && area > maxArea) {
                maxArea = area;
            }
        }
        
        return maxArea;
        
    }
}