class Solution {
    public String toHex(int num) {
        if(num == 0) return "0";
        char[] map = {'0','1','2','3','4','5','6','7', '8','9','a','b','c','d','e','f'};
        StringBuilder hex = new StringBuilder();
        while(num != 0){
            int digit = num & 15;
            hex.append(map[digit]);
            num >>>= 4;

        }
        return hex.reverse().toString();

        
    }
}