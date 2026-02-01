class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zCount = 0;
        int maxLen = 0;
        for(int right = 0 ; right < nums.length; right++){
            if(nums[right] == 0){
                zCount++;
            }
            while(zCount > k){
                if(nums[left] == 0){
                    zCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);

        } 
        return maxLen;   
    }
}