class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums){
             max = Math.max(max , num);

        }
        int[] freq = new int[max + 1];
        for(int num : nums){
            freq[num]++;
        }
        int[] points = new int[max + 1];
        for(int i = 0 ; i <= max ; i++){
            points[i] = i * freq[i];
        }
        if(max == 0){
            return 0;
        }

        int[] dp = new int[max + 1];
        dp[0] = 0;
        dp[1] = points[1];
        for(int i = 2; i <= max ; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
        }

        return dp[max];
        
    }
}