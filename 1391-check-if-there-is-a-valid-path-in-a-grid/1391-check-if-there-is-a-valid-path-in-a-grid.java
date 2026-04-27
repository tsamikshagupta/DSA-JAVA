class Solution {
    public boolean hasValidPath(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][][] d = {
            {},
            {{0,-1},{0,1}},
            {{-1,0},{1,0}},
            {{0,-1},{1,0}},
            {{0,1},{1,0}},
            {{0,-1},{-1,0}},
            {{0,1},{-1,0}}
        };
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            if (r == m-1 && c == n-1) return true;
            for (int[] mv : d[g[r][c]]) {
                int nr = r + mv[0];
                int nc = c + mv[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || vis[nr][nc]) continue;
                for (int[] back : d[g[nr][nc]]) {
                    if (nr + back[0] == r && nc + back[1] == c) {
                        vis[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                        break;
                    }
                }
            }
        }
        
        return false;
    }
}