class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int cnt = words.length;
        int wl = words[0].length();
        int total = cnt * wl;
        if (n < total) return ans;
        Map<String, Integer> mp = new HashMap<>();
        for (String w : words) {
            mp.put(w, mp.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < wl; i++) {
            int l = i;
            int c = 0;
            Map<String, Integer> cur = new HashMap<>();
            for (int r = i; r + wl <= n; r += wl) {
                String w = s.substring(r, r + wl);
                if (mp.containsKey(w)) {
                    cur.put(w, cur.getOrDefault(w, 0) + 1);
                    c++;
                    while (cur.get(w) > mp.get(w)) {
                        String lw = s.substring(l, l + wl);
                        cur.put(lw, cur.get(lw) - 1);
                        l += wl;
                        c--;
                    }
                    if (c == cnt) {
                        ans.add(l);
                        String lw = s.substring(l, l + wl);
                        cur.put(lw, cur.get(lw) - 1);
                        l += wl;
                        c--;
                    }

                } else {
                    cur.clear();
                    c = 0;
                    l = r + wl;
                }
            }
        }

        return ans;
    }
}