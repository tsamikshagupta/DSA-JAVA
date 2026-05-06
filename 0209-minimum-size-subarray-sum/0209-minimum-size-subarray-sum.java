class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length , l = 0 , s = 0 , ans = Integer.MAX_VALUE;
        for(int r = 0 ; r < n ; r++){
            s += nums[r];
            while(s >= target){
                ans = Math.min(ans , r - l + 1);
                s -= nums[l++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
        
    }
}