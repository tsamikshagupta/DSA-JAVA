import java.util.*;
class Solution {
    public static int findMin(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int left = 0;
        int right = n-1;
        if(nums[left]<nums[right]) return nums[0];
        while(left< right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
            
        }
        return nums[left];   
    }

}