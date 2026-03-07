class Solution {
    public int minFlips(String s) {

        int n = s.length();
        String ss = s + s;

        int diff1 = 0;
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < ss.length(); i++){

            char c = ss.charAt(i);

            char p1 = (i % 2 == 0) ? '0' : '1';
            char p2 = (i % 2 == 0) ? '1' : '0';

            if(c != p1) diff1++;
            if(c != p2) diff2++;

            if(i >= n){
                char prev = ss.charAt(i-n);

                char oldp1 = ((i-n) % 2 == 0) ? '0' : '1';
                char oldp2 = ((i-n) % 2 == 0) ? '1' : '0';

                if(prev != oldp1) diff1--;
                if(prev != oldp2) diff2--;
            }

            if(i >= n-1){
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}