class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
        }
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        k--;
        StringBuilder ans = new StringBuilder();
        while (!nums.isEmpty()) {
            int idx = k / fact;
            ans.append(nums.get(idx));
            nums.remove(idx);
            if (nums.isEmpty()) {
                break;
            }
            k %= fact;
            fact /= nums.size();
        }
        return ans.toString();
    }
}