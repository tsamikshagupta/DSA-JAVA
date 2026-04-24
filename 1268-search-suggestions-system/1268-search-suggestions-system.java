class Solution {
    public List<List<String>> suggestedProducts(String[] p, String s) {
        Arrays.sort(p);
        List<List<String>> res = new ArrayList<>();
        String pre = "";
        for (char c : s.toCharArray()) {
            pre += c;
            int idx = lb(p, pre);
            List<String> cur = new ArrayList<>();
            for (int i = idx; i < p.length && cur.size() < 3; i++) {
                if (p[i].startsWith(pre)) {
                    cur.add(p[i]);
                } else {
                    break;
                }
            }
            res.add(cur);
        }
        return res;
    }
    
    private int lb(String[] p, String t) {
        int l = 0, r = p.length - 1, ans = p.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (p[m].compareTo(t) >= 0) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return ans;
    }
}