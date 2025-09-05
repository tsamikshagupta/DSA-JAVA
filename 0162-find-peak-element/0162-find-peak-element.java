class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int left = 0, right = n-1;
        while(left<=right){
            int mid = left + (right - left) /2;
            boolean leftSmaller = mid ==0 || nums[mid]> nums[mid - 1];
            boolean rightSmaller = mid ==n-1 || nums[mid] > nums[mid+1];
            if(leftSmaller && rightSmaller) return mid;
            if(mid > 0 && nums[mid-1] > nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
        
    }
}