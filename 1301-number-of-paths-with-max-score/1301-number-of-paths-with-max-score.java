class Solution {
    static final int MOD = 1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] best = new int[n][n], ways = new int[n][n];
        for (int[] row : best) Arrays.fill(row, -1);
        best[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;
        int[] dr = {-1, 0, -1};
        int[] dc = {0, -1, -1};
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X' || best[i][j] == -1) continue;
                for (int k = 0; k < 3; k++) {
                    int r = i + dr[k], c = j + dc[k];
                    if (r < 0 || c < 0 || board.get(r).charAt(c) == 'X') continue;
                    char ch = board.get(r).charAt(c);
                    int add = Character.isDigit(ch) ? ch - '0' : 0;
                    int score = best[i][j] + add;
                    if (score > best[r][c]) {
                        best[r][c] = score;
                        ways[r][c] = ways[i][j];
                    } else if (score == best[r][c]) {
                        ways[r][c] = (ways[r][c] + ways[i][j]) % MOD;
                    }
                }
            }
        }
        return ways[0][0] == 0 ? new int[]{0, 0} : new int[]{best[0][0], ways[0][0]};
    }
}