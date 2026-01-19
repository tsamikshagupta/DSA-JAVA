class Solution {
    public int balancedStringSplit(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int count=0;
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int l=0,r=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L') l++;
            else r++;
            if(l==r) count++;
        }
        return count;
        
    }
}