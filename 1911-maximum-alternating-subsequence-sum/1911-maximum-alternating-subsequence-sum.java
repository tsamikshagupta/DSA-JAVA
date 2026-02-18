class Solution {
    public long maxAlternatingSum(int[] nums) {
        long add = 0;      
        long subtract = 0; 
        for (int num : nums) {
            long newAdd = Math.max(add, subtract + num);
            long newSubtract = Math.max(subtract, add - num);
            add = newAdd;
            subtract = newSubtract;
        }
        return add;
    }
}
