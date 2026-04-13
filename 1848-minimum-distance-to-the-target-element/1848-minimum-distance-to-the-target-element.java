class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minimum = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target){
                minimum = Math.min(minimum , Math.abs(i - start));
            }
        }
        return minimum;
    }
}