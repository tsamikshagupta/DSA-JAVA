class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> 
            a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]
        );
        List<Integer> nums = new ArrayList<>();
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int count = 0;
            if (nums.size() >= 1 && nums.get(nums.size() - 1) >= start)
                count++;
            if (nums.size() >= 2 && nums.get(nums.size() - 2) >= start)
                count++;
            if (count >= 2) continue;
            if (count == 1) {
                nums.add(end);
                continue;
            }
            nums.add(end - 1);
            nums.add(end);
        }
        return nums.size();
    }
        
    }
