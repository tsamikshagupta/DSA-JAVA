class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[] prev = new long[n];
        long[] curr = new long[n]; 

        for (int t = 1; t <= k; t++) {
            long bestBuy = - (long) prices[0]; 
            long bestSell = (long) prices[0];  

            curr[0] = 0;

            for (int i = 1; i < n; i++) {
                long closeToday = Math.max(bestBuy + prices[i], bestSell - prices[i]);
                curr[i] = Math.max(curr[i - 1], closeToday);
                bestBuy = Math.max(bestBuy, prev[i - 1] - (long) prices[i]);
                bestSell = Math.max(bestSell, prev[i - 1] + (long) prices[i]);
            }

            long[] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        return prev[n - 1];  
    }
}