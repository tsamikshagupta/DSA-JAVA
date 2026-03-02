class Solution {
    public String convertToTitle(int columnNumber) {
        Stack<Character> stack = new Stack<>();
        while(columnNumber > 0){
            columnNumber--;
            stack.push((char)('A' + (columnNumber % 26)));
            columnNumber/= 26;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
        
        
    }
}