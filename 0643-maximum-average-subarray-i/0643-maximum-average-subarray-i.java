class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < k ; i++){
            sum += nums[i];
        }
        double max = (double)sum / k;
        for(int i = k ; i < n ; i++){
            sum = sum - nums[i - k] + nums[i];
            double avg = (double)sum / k;
            if(avg > max){
                max = avg;
            }
        }
        return max;
        
    }
}