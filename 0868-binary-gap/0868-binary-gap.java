class Solution {
    public int binaryGap(int n) {
        List<Integer> ones = new ArrayList<>();
        int pos = 0;
        while(n > 0){
            if((n & 1) == 1){
                ones.add(pos);
            }
            n >>= 1;
            pos++;
        }
        int max = 0;
        for(int i = 1 ; i < ones.size(); i++){
            max = Math.max(max , ones.get(i) - ones.get(i - 1));
        }
        return max;
        
    }
}