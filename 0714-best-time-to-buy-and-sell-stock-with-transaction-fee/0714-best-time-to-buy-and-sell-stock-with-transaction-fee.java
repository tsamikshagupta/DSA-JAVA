class Solution {
    public int maxProfit(int[] prices, int fee) {
        int h = -prices[0];
        int cash = 0;
        for(int i = 1 ; i < prices.length ; i++){
            h = Math.max(h , cash - prices[i]);
            cash = Math.max(cash , h + prices[i] - fee);
        }
        return cash; 
    }
}