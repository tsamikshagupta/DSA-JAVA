class MyQueue {
    Stack<Integer> instack;
    Stack<Integer> outstack;

    public MyQueue() {
        instack = new Stack<>();
        outstack = new Stack<>();
        
    }
    
    public void push(int x) {
        instack.push(x);
        
    }
    
    public int pop() {
        shiftStacks();
        return outstack.pop();
        
    }
    
    public int peek() {
        shiftStacks();
        return outstack.peek();
        
    }
    
    public boolean empty() {
        return instack.isEmpty() && outstack.isEmpty();
        
    }
    private void shiftStacks(){
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */