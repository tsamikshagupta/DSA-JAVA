class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for(char c : t.toCharArray()){
            need.put(c, need.getOrDefault(c,0)+1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int required = need.size();
        int formed = 0;
        int left = 0 , right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c,0)+1);
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                 formed++;
        }
          while (left <= right && formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (need.containsKey(leftChar) &&
                    window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
        
    }
}