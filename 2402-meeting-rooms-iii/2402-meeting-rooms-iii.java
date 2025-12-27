class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 0; i < n; i++) available.offer(i);
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                long[] finished = busy.poll();
                available.offer((int) finished[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                count[room]++;
                busy.offer(new long[]{start + duration, room});
            } else {
                long[] soonest = busy.poll();
                long freeTime = soonest[0];
                int room = (int) soonest[1];

                count[room]++;
                busy.offer(new long[]{freeTime + duration, room});
            }
        }
        int bestRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[bestRoom]) bestRoom = i;
        }
        return bestRoom;
        
    }
}