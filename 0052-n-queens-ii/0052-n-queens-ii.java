class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>(); 
        Set<Integer> diag2 = new HashSet<>(); 
        backtrack(0, n, cols, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n,Set<Integer> cols,Set<Integer> diag1, Set<Integer> diag2) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) ||
                diag1.contains(row - col) ||
                diag2.contains(row + col)) {
                continue;
            }
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);
            backtrack(row + 1, n, cols, diag1, diag2);
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}