class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] dp = new int[m + 1];
        for (int j = m - 1; j >= 0; j--) {
            dp[j] = dp[j + 1] + s2.charAt(j);
        }
        for (int i = n - 1; i >= 0; i--) {
            int prevDiag = dp[m];            
            dp[m] += s1.charAt(i);         

            for (int j = m - 1; j >= 0; j--) {
                int temp = dp[j];           
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[j] = prevDiag;        
                } else {
                    int delS1 = s1.charAt(i) + dp[j];    
                    int delS2 = s2.charAt(j) + dp[j + 1]; 
                    dp[j] = Math.min(delS1, delS2);
                }
                prevDiag = temp;            
            }
        }

        return dp[0];
        
    }
}