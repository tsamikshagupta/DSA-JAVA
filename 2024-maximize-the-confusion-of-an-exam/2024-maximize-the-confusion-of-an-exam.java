class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int l = 0;
        int n = s.length();
        int max = -1;
        int ans = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < n; i++){
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch , 0) + 1);
            int curr= map.get(ch);
            max = Math.max(max , curr);
            int win = (i - l + 1);
            int m = win - max;
            while(m > k){
                Character left = s.charAt(l);
                map.put(left, map.get(left) - 1);
                if(map.get(left) == 0) map.remove(left);
                m--;
                l++;
            }
            ans= Math.max(ans,i - l + 1);
        }
        return ans;
    }
}