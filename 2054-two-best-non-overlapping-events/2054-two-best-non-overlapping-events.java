class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        int bestPastValue = 0;
        int answer = 0;
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];
            while (!pq.isEmpty() && pq.peek()[1] < start) {
                bestPastValue = Math.max(bestPastValue, pq.poll()[2]);
            }
            answer = Math.max(answer, bestPastValue + value);
            answer = Math.max(answer, value);
            pq.offer(event);
        }

        return answer;
    }
}
