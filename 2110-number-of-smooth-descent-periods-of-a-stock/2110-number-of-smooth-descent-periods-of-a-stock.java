class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 0;
        long currentLength = 1; 
        result += currentLength;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                currentLength++;
            } else {
                currentLength = 1;
            }
            result += currentLength;
        }
        return result;
        
    }
}