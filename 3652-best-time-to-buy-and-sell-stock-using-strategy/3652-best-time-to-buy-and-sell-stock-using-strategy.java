class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int h = k / 2;
        long originalProfit = 0;
        for (int i = 0; i < n; i++) {
            originalProfit += (long) strategy[i] * prices[i];
        }
        long[] prefixA = new long[n + 1];
        long[] prefixB = new long[n + 1];

        for (int i = 0; i < n; i++) {
            long A = -(long) strategy[i] * prices[i];
            long B = (long) (1 - strategy[i]) * prices[i];

            prefixA[i + 1] = prefixA[i] + A;
            prefixB[i + 1] = prefixB[i] + B;
        }

        long maxGain = 0;
        for (int l = 0; l + k <= n; l++) {
            long firstHalf = prefixA[l + h] - prefixA[l];
            long secondHalf = prefixB[l + k] - prefixB[l + h];
            long gain = firstHalf + secondHalf;
            maxGain = Math.max(maxGain, gain);
        }

        return originalProfit + maxGain;
    }
}