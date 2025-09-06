import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < basket1.length; i++) {
            freq.put(basket1[i], freq.getOrDefault(basket1[i], 0) + 1);
            freq.put(basket2[i], freq.getOrDefault(basket2[i], 0) - 1);
        }

        List<Integer> swaps = new ArrayList<>();
        for (int key : freq.keySet()) {
            int count = freq.get(key);
            if (count % 2 != 0) return -1; 
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                swaps.add(key);
            }
        }
        
        int minVal = Integer.MAX_VALUE;
        for (int val : basket1) minVal = Math.min(minVal, val);
        for (int val : basket2) minVal = Math.min(minVal, val);
        
        Collections.sort(swaps);
        
        long cost = 0;
        for (int i = 0; i < swaps.size() / 2; i++) {
          
            cost += Math.min(swaps.get(i), 2 * minVal);
        }
        
        return cost;
    }

    
}