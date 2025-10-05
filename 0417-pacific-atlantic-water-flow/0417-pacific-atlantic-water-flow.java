import java.util.*;
class Solution {
    private int[][] heights;
    private int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int c = 0; c < n; c++) {
            dfs(0, c, pacific, heights[0][c]);
        }
        for (int r = 0; r < m; r++) {
            dfs(r, 0, pacific, heights[r][0]);
        }
        for (int c = 0; c < n; c++) {
            dfs(m - 1, c, atlantic, heights[m - 1][c]); 
        }
        for (int r = 0; r < m; r++) {
            dfs(r, n - 1, atlantic, heights[r][n - 1]); 
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int prevHeight) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }
        visited[r][c] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(nr, nc, visited, heights[r][c]);
        }
    }
}