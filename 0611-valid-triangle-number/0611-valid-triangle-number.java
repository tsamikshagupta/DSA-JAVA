class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[j] == 0) continue; 
                int k = j + 1;
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;

    }
}