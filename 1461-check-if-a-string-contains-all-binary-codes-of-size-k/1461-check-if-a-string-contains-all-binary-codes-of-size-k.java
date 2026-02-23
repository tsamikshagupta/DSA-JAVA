class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        if(s.length() - k + 1 < need) return false;
        BitSet seen = new BitSet(need);
        int mask = need - 1;
        int hash = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = ((hash << 1) & mask) | (s.charAt(i) - '0');
            if (i >= k - 1 && !seen.get(hash)) {
                seen.set(hash);
                count++;
                if (count == need) return true;
            }
        }
        return false;  
    }
}