class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int currsum=0;
        int suppsum=0;
        for(int i = 0 ; i <= n ; i++){
            suppsum += i;
        }
        for(int i = 0 ; i<=nums.length-1 ; i++){
            currsum += nums[i];
        }
        int digit = suppsum - currsum;
        return digit;
        
    }
}