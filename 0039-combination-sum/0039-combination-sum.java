class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
        for (int i = 0; i <= target; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(new ArrayList<>());
        for (int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            for (int j = num; j <= target; j++) {
                for (List<Integer> comb : dp.get(j - num)) {
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(num);
                    dp.get(j).add(newComb);
                }
            }
        }
        
        return dp.get(target);
    }
}
    