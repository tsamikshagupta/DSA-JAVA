class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int curr = 0;
        int max = nums[0];
        int min = 0;
        int minsum = nums[0];
        for(int num : nums){
            total += num;
            curr = Math.max(num , curr + num);
            max = Math.max(max , curr);
            min = Math.min(num , min + num);
            minsum = Math.min(minsum , min);
        }
        if(max < 0){
            return max;
        }
        return Math.max(max , total - minsum);
    }
}