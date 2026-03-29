class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int n : nums1) s1.add(n);
        for (int n : nums2) s2.add(n);

        List<Integer> l1 = new ArrayList<>();
        for (int n : s1) {
            if (!s2.contains(n)) l1.add(n);
        }

        List<Integer> l2 = new ArrayList<>();
        for (int n : s2) {
            if (!s1.contains(n)) l2.add(n);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(l1);
        result.add(l2);

        return result;
    }
}