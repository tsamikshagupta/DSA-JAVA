class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> rows = new HashSet<>();
        Set<String> cols = new HashSet<>();
        Set<String> boxes = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j = 0 ; j<9;j++){
                char cell = board[i][j];
                if(cell == '.') continue;
                String rowKey = i + "r" + cell;
                String colKey = j + "c" + cell;
                String boxKey = (i/3) * 3 + (j/3) + "b" + cell;
                if(rows.contains(rowKey) || cols.contains(colKey) || boxes.contains(boxKey)) return false;
                rows.add(rowKey);
                cols.add(colKey);
                boxes.add(boxKey);

            }
        }
        return true;  
    }
}