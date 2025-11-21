class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }
     private void backtrack(int index, String s, List<String> path, List<String> result) {
        if (path.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }
         for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;
            String segment = s.substring(index, index + len);
            if (isValid(segment)) {
                path.add(segment);
                backtrack(index + len, s, path, result);
                path.remove(path.size() - 1);  
            }
        }
    }
    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') return false;
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
        
    
}