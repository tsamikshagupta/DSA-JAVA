import java.util.*;
class Solution {
    public int climbStairs(int n) {
        if (n < 0) return 0; 
        if (n == 0) return 0;
        if (n == 1) return 1;
        int prev1 = 1; 
        int prev2 = 2; 
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
    
}