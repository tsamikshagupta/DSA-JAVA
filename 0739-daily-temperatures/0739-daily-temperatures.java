class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer>  stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int prevday = stack.pop();
                answer[prevday] = i - prevday;

            }
            stack.push(i);
        }  
        return answer;    
    }
}