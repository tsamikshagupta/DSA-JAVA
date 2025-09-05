import java.util.*;
class Solution {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        long val = 1;
        for(int k=1; k<=rowIndex;k++){
            val = val * (rowIndex-k+1) / k;
            row.add((int) val);
        }
        return row;
    }
    
}