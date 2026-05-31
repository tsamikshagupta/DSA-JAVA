class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    private Node build(int[][] grid, int r, int c, int size) {
        if (same(grid, r, c, size)) {
            return new Node(grid[r][c] == 1, true);
        }
        int half = size / 2;
        Node tl = build(grid, r, c, half);
        Node tr = build(grid, r, c + half, half);
        Node bl = build(grid, r + half, c, half);
        Node br = build(grid, r + half, c + half, half);
        return new Node(true, false, tl, tr, bl, br);
    }

    private boolean same(int[][] grid, int r, int c, int size) {
        int val = grid[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}