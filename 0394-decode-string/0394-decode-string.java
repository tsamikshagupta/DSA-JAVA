class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); 
            } 
            else if (c == '[') {
                countStack.push(k);
                stringStack.push(curr);
                curr = new StringBuilder();
                k = 0;
            } 
            else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();
                
                for (int i = 0; i < repeat; i++) {
                    prev.append(curr);
                }
                
                curr = prev;
            } 
            else {
                curr.append(c);
            }
        }

        return curr.toString();
    }
}