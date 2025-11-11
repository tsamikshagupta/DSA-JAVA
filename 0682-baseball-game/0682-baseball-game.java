class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String op : operations){
            if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(op.equals("+")){
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top);
                stack.push(newScore);
            }else{
                stack.push(Integer.parseInt(op));
            }

        }
        int sum = 0;
        for(int score : stack){
            sum += score;
        }
        return sum;
        
    }
}