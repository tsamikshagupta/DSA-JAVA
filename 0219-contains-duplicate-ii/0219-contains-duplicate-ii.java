class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(window.contains(nums[i])){
                return true;
            }
            window.add(nums[i]);
            if(window.size() > k){
                window.remove(nums[i - k]);
            }

        }
        return false;
        
        
        
    }
}