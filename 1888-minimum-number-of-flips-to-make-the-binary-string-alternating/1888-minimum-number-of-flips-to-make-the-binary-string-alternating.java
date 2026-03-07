class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String ds = s + s;
        int d1 = 0 , d2 = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < ds.length(); i++){
            char c = ds.charAt(i);
            char a = (i % 2 == 0) ? '0' : '1';
            char b = (i % 2 == 0) ? '1' : '0';
            if(c != a) d1++;
            if(c != b) d2++;
            if(i >= n){
                char p = ds.charAt(i - n);
                char pa = ((i - n) % 2 == 0) ? '0' : '1';
                char pb = ((i - n) % 2 == 0) ? '1' : '0';
                if (p != pa) d1--;
                if (p != pb) d2--;
            }
            if(i >= n - 1){
                ans = Math.min(ans , Math.min(d1, d2));
            }
        }
        return ans;
        
    }
}