class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer , Integer> freq = new HashMap<>();
        long sum = 0 ;
        long maxsum = 0;
        for(int i = 0 ; i < n ; i++){
            int incoming = nums[i];
            sum += incoming;
            freq.put(incoming , freq.getOrDefault(incoming , 0) + 1);
            if(i >= k){
                int outgoing = nums[i-k];
                sum -= outgoing;
                freq.put(outgoing , freq.get(outgoing) - 1);
                if(freq.get(outgoing) == 0){
                    freq.remove(outgoing);
                }
            }
            if(i >= k - 1 && freq.size()==k){
                maxsum = Math.max(maxsum , sum);
            }
        }
        return maxsum;

        
    }
}