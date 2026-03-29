class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int count : freq.values()) {
            if (seen.contains(count)) return false;
            seen.add(count);
        }
        return true;
    }
}