class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        int n = happiness.length;
        int decrement = 0;
        for (int i = n - 1; i >= n - k; i--) {
            int effectiveHappiness = happiness[i] - decrement;
            if (effectiveHappiness > 0) {
                sum += effectiveHappiness;
            }
            decrement++;
        }

        return sum;
        
    }
}