class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            set.add(nums[i]);
        }
        for(int i = 1 ; i <= n ; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }
        return result;

        
    }
}