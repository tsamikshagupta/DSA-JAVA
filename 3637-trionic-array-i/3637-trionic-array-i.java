class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false; 

        int i = 1;
        while (i < n && nums[i] > nums[i - 1]) i++;
        int endInc1 = i - 1;   
        if (endInc1 == 0) return false; 
        int startDec = i;
        while (i < n && nums[i] < nums[i - 1]) i++;
        int endDec = i - 1;       
        if (i == startDec) return false; 
        int startInc2 = i;
        while (i < n && nums[i] > nums[i - 1]) i++;
        if (i == startInc2) return false; 
        return i == n;
    }
}
