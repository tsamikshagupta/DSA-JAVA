import java.util.*;

class Solution {

    // Multiset using TreeMap (value -> count)
    static class MultiSet {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = 0;

        void add(int x) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            size++;
        }

        void remove(int x) {
            int c = map.get(x);
            if (c == 1) map.remove(x);
            else map.put(x, c - 1);
            size--;
        }

        int first() { return map.firstKey(); }
        int last() { return map.lastKey(); }

        boolean contains(int x) { return map.containsKey(x); }
        boolean isEmpty() { return size == 0; }
    }

    private MultiSet small = new MultiSet(); // holds k-2 smallest in window
    private MultiSet large = new MultiSet(); // holds remaining
    private long sumSmall = 0;
    private int need; // = k-2

    private void rebalance() {
        // Ensure small has exactly 'need' elements (when possible)
        while (small.size < need && !large.isEmpty()) {
            int x = large.first();
            large.remove(x);
            small.add(x);
            sumSmall += x;
        }
        while (small.size > need) {
            int x = small.last();
            small.remove(x);
            sumSmall -= x;
            large.add(x);
        }
    }

    private void addVal(int v) {
        if (need == 0) { // nothing to maintain in small
            large.add(v);
            return;
        }

        if (small.size < need) {
            small.add(v);
            sumSmall += v;
        } else {
            // small is full
            int largestInSmall = small.last();
            if (v < largestInSmall) {
                small.remove(largestInSmall);
                sumSmall -= largestInSmall;
                large.add(largestInSmall);

                small.add(v);
                sumSmall += v;
            } else {
                large.add(v);
            }
        }
        rebalance();
    }

    private void removeVal(int v) {
        if (small.contains(v)) {
            small.remove(v);
            sumSmall -= v;
        } else {
            large.remove(v);
        }
        rebalance();
    }

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        need = k - 2;

        // Build initial window for i1 = 1:
        // window elements are nums[2 .. 1+dist]
        int start = 2;
        int end = Math.min(n - 1, 1 + dist);

        for (int i = start; i <= end; i++) addVal(nums[i]);

        long best = Long.MAX_VALUE;

        // i1 ranges so that we can still form k subarrays
        for (int i1 = 1; i1 <= n - k + 1; i1++) {
            // evaluate with current window [i1+1 .. i1+dist]
            best = Math.min(best, (long) nums[i1] + sumSmall);

            // slide window to next i1:
            // remove outgoing index (i1+1)
            int outIdx = i1 + 1;
            if (outIdx <= n - 1) removeVal(nums[outIdx]);

            // add incoming index (i1+dist+1)
            int inIdx = i1 + dist + 1;
            if (inIdx <= n - 1) addVal(nums[inIdx]);
        }

        return nums[0] + best;
    }
}
