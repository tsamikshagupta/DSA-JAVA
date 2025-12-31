class Solution {
    private int R, C;
    private int[][] cells;

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.R = row;
        this.C = col;
        this.cells = cells;

        int n = row * col;
        int lo = 0, hi = n; 

        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2; 
            if (canCross(mid)) {
                lo = mid;      
            } else {
                hi = mid - 1;  
            }
        }
        return lo;
    }
    private boolean canCross(int day) {
        boolean[][] water = new boolean[R][C];
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            water[r][c] = true;
        }

        boolean[][] vis = new boolean[R][C];
        Deque<Integer> q = new ArrayDeque<>();
        for (int c = 0; c < C; c++) {
            if (!water[0][c]) {
                vis[0][c] = true;
                q.addLast(0 * C + c);
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int code = q.removeFirst();
            int r = code / C;
            int c = code % C;

            if (r == R - 1) return true; 
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C
                        && !water[nr][nc] && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.addLast(nr * C + nc);
                }
            }
        }

        return false;
    }
}
