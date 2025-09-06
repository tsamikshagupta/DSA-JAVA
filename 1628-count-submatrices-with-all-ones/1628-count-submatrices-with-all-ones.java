class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] heights = new int[n]; 
        int totalCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               
                heights[j] = (mat[i][j] == 1) ? heights[j] + 1 : 0;
            }
            
            for (int j = 0; j < n; j++) {
                if (heights[j] == 0) continue;
                int minHeight = heights[j];
                
                for (int k = j; k >= 0 && heights[k] > 0; k--) {
                    minHeight = Math.min(minHeight, heights[k]);
                    totalCount += minHeight;
                }
            }
        }
        return totalCount;
    }
}
        
    
