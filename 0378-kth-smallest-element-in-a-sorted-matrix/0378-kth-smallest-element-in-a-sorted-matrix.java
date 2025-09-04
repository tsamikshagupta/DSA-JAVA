class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low<high){
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(matrix, mid);
            if(count < k){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
        
    }
    private int countLessOrEqual(int[][] matrix, int target){
        int n = matrix.length;
        int count = 0 ;
        int row = 0, col = n - 1;
        while(row<n && col>=0){
            if(matrix[row][col]<=target){
                count += col +1;
                row++;
            }else{
                col--;
            }
        }
        return count;
    }
}