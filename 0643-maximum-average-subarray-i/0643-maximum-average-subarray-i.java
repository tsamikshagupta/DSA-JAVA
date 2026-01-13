class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double max = 0;
        for(int i = 0 ; i < k ; i++){
            max += nums[i];
        }
        double maxSum = max;
        double maxAvg = Integer.MIN_VALUE;
        for(int i = k ; i < n ; i++){
            max += nums[i] - nums[i - k];
            maxSum = Math.max(max , maxSum);
        }
        maxAvg = maxSum / k;
        return maxAvg;
        
    }
}