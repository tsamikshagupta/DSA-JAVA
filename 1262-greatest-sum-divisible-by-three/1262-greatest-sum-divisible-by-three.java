class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;
        
        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();
        
        for (int num : nums) {
            total += num;
            if (num % 3 == 1) {
                rem1.add(num);
            } else if (num % 3 == 2) {
                rem2.add(num);
            }
        }
        Collections.sort(rem1);
        Collections.sort(rem2);
        if (total % 3 == 0) return total;
        int mod = total % 3;
        int option1 = Integer.MAX_VALUE;
        int option2 = Integer.MAX_VALUE;
        if (mod == 1) {
            if (rem1.size() >= 1) option1 = rem1.get(0);  
            if (rem2.size() >= 2) option2 = rem2.get(0) + rem2.get(1); 
        }
        else if (mod == 2) {
            if (rem2.size() >= 1) option1 = rem2.get(0);  
            if (rem1.size() >= 2) option2 = rem1.get(0) + rem1.get(1);
        }

        int remove = Math.min(option1, option2);
        if (remove == Integer.MAX_VALUE) return 0;

        return total - remove;
        
    }
}