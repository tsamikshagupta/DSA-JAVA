class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int start, int[] cand, int target, 
        List<Integer> path, List<List<Integer>> result) {
        if (target==0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i<cand.length;i++) {
            if (i>start && cand[i] ==cand[i-1]) continue;
            if (cand[i]>target) break;
            path.add(cand[i]);
            backtrack(i+1,cand,target-cand[i],path,result);
            path.remove(path.size()-1);
        }
    }
     
    }
        

