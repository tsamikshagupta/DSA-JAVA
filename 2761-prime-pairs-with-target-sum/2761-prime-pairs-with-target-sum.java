class Solution {
    private boolean isPrime(int n){
        if(n< 2) return false;
        for(int i = 2 ; i * i <= n ; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 2 ; i<= n ; i++){
            int j = n - i;
            if(i > j) break;
            if(isPrime(i) && isPrime(j)){
                res.add(Arrays.asList(i , j));
            }
        }
        return res;
        
    }
}