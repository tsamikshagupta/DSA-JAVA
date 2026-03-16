class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> remove = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            }else if(c == ')'){
                if(!st.isEmpty()){
                    st.pop();
                }else{
                    remove.add(i);
                }
            }

        }
         while(!st.isEmpty()){
                remove.add(st.pop());
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < s.length() ; i++){
                if(!remove.contains(i)){
                    sb.append(s.charAt(i));
                }
            }
        return sb.toString();
        
    }
}