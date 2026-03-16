class Solution {
    public static int maxSubArray(int[] nums) {
        int curr = 0 , max = nums[0];
        for(int x : nums){
            curr = Math.max(x , curr + x);
            max = Math.max(max , curr);
        }
        return max;  
    }
    
}