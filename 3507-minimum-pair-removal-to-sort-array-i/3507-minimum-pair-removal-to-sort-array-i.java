class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int x : nums) arr.add(x);
        int operations = 0;
        while (!isNonDecreasing(arr)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < arr.size() - 1; i++) {
                int sum = arr.get(i) + arr.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }
            arr.remove(index);       
            arr.remove(index);       
            arr.add(index, minSum);  
            operations++;
        }

        return operations;
        
    }
    private boolean isNonDecreasing(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}