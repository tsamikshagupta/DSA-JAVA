class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc = image[sr][sc];
        if(oc == color) return image;
        int m = image.length;
        int n = image[0].length;
        int[][] dir = {
            {1,0},{-1, 0},{0,1},{0,-1}
        };
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc});
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == oc) {
                    image[nr][nc] = color;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return image;
        
        
    }
}