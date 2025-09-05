import java.util.*;
class Solution {
    public static boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p, memo);
    }
    private static boolean dp(int i, int j, String s, String p, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        boolean match = i < s.length() && 
                       (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            
            memo[i][j] = dp(i, j + 2, s, p, memo) || 
                         (match && dp(i + 1, j, s, p, memo));
        } else {
           
            memo[i][j] = match && dp(i + 1, j + 1, s, p, memo);
        }
        
        return memo[i][j];
    }


}
    