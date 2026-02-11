class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res[i] = prices[i] - stack.peek();

            }else{
                res[i] = prices[i];
            }
            stack.push(prices[i]);
        }
        return res;
        
    }
}