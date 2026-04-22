class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int start, int k, int target, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k && target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (temp.size() > k || target < 0) return;
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(i + 1, k, target - i, temp, result);
            temp.remove(temp.size() - 1); 
        }
    }
}