class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums,nums.length, result);
        return result;
    }
    private void generatePermutations(int[] nums,int size,List<List<Integer>> result) {
        if (size == 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int num:nums) {
                permutation.add(num);
            }
            result.add(permutation);
            return;
        }
        for (int i = 0;i<size;i++) {
            generatePermutations(nums,size - 1,result);
            if (size % 2 == 0) {
                swap(nums,i, size-1);
            } else {
                swap(nums,0,size-1);
            }
        }
    }
    private void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
        
    
