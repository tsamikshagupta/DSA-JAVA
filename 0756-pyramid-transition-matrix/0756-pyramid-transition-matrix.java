class Solution {
    private Map<String, List<Character>> map = new HashMap<>();
    private Set<String> failed = new HashSet<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
         for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }
        return dfs(bottom);
        
    }
    private boolean dfs(String bottom) {
        if (bottom.length() == 1) return true;
        if (failed.contains(bottom)) return false;
        List<String> nextRows = new ArrayList<>();
        buildNextRows(bottom, 0, new StringBuilder(), nextRows);

        for (String next : nextRows) {
            if (dfs(next)) return true;
        }

        failed.add(bottom); 
        return false;
    }
    private void buildNextRows(String bottom, int index,StringBuilder current,List<String> result) {
        if (index == bottom.length() - 1) {
            result.add(current.toString());
            return;
        }

        String key = "" + bottom.charAt(index) + bottom.charAt(index + 1);
        if (!map.containsKey(key)) return;
        for (char c : map.get(key)) {
            current.append(c);
            buildNextRows(bottom, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }

    }
}