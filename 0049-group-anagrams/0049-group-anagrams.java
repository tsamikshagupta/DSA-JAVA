class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedstr = new String(chars);
            map.computeIfAbsent(sortedstr, k->new ArrayList<>()).add(str);
            
        }
        return new ArrayList<>(map.values());
        
    }
   
}