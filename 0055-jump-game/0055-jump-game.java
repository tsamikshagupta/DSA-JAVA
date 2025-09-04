class Solution {
    public boolean canJump(int[] nums) {
        int finalPos = nums.length-1;
        for(int idx = nums.length - 2 ; idx >= 0; idx--){
            if(idx+ nums[idx]>=finalPos){
                finalPos = idx;
            }

        }
        return finalPos == 0;

    }
}