class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        long need = total % p;
        if (need == 0) return 0;  
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);   
        long prefix = 0;
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            long target = (prefix - need + p) % p;
            if (map.containsKey(target)) {
                minLen = Math.min(minLen, i - map.get(target));
            }
            map.put(prefix, i);
        }
        return minLen == nums.length ? -1 : minLen;
    }
}