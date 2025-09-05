import java.util.*;
class Solution {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2]; 
    }
    
}