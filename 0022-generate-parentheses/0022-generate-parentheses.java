class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        for(int i = 0 ; i<=n; i++){
            dp.add(new ArrayList<>());
        }
        dp.get(0).add("");
        if(n>=1){
            dp.get(1).add("()");
        }
        for(int i = 2; i<=n; i++){
            for(int j = 0; j<i;j++){
                for(String inside : dp.get(j)){
                    for(String outside : dp.get(i - j - 1)){
                    dp.get(i).add("(" + inside + ")" + outside);
                }
            }
        }
        }
        return dp.get(n);
        
    }

}