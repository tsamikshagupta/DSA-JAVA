class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int wtrapped = 0;
        int leftmax = 0 , rightmax = 0;
        while(left < right){
            leftmax = Math.max(height[left] , leftmax);
            rightmax = Math.max(height[right] , rightmax);
            if(leftmax <= rightmax){
                int wlevel = Math.min(leftmax , rightmax);
                wtrapped += wlevel - height[left];
                left++;
            }else{
                int wlevel = Math.min(leftmax , rightmax);
                wtrapped += wlevel - height[right];
                right--;
            }

        }
        return wtrapped; 
    }
}