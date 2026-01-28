class Solution {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;
        while(left < right){
            int currentarea = Math.min(height[left], height[right]) * (right - left);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
            maxarea = Math.max(currentarea , maxarea);

        }
        return maxarea;
    
    }
}