class Solution {
    public static int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int currentHeight = Math.min(height[left],height[right]);
            int width = right-left;
            int area = currentHeight * width;

             maxArea = Math.max(maxArea,area);

             if(height[left]< height[right]){
                left++;
             }
             else{
                right--;
             }
        }
        return maxArea;
    }
}