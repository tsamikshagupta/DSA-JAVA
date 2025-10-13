class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String result = "1";
        for(int i=2; i<=n;i++){
            result = optimizedRunLengthEncoding(result);
        }
        return result;
        
    }
    private String optimizedRunLengthEncoding(String s){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            int j = i;
            while(j < s.length() && s.charAt(j) == s.charAt(i)){
                j++;
            }
            sb.append(j - i).append(s.charAt(i));
            i = j;
        }
          return sb.toString();
    }
}