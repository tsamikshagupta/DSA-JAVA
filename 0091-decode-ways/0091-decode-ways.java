class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;  

        for (int i = 2; i <= n; i++) {
            char c1 = s.charAt(i - 1);  
            char c2 = s.charAt(i - 2);    
            if (c1 != '0') {
                dp[i] += dp[i - 1];
            }
            int twoDigit = (c2 - '0') * 10 + (c1 - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];     
    }
}