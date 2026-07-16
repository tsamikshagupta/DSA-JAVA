class Solution {
    public long gcdSum(int[] nums) {
         int n = nums.length;
        int[] prefixGcd = new int[n];
        int maximum = nums[0];
        for (int i = 0; i < n; i++) {
            maximum = Math.max(maximum, nums[i]);
            prefixGcd[i] = findGcd(nums[i], maximum);
        }
        Arrays.sort(prefixGcd);
        long sum = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            sum += findGcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        return sum;  
    }
     private int findGcd(int first, int second) {
        while (second != 0) {
            int remainder = first % second;
            first = second;
            second = remainder;
        }
        return first;
    }
}