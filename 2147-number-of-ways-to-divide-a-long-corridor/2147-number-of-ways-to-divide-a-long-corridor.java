class Solution {
    public int numberOfWays(String corridor) {
        final long MOD = 1_000_000_007;
        List<Integer> seats = new ArrayList<>();
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seats.add(i);
            }
        }

        int totalSeats = seats.size();
        if (totalSeats == 0 || totalSeats % 2 != 0) return 0;

        long ways = 1;

        for (int i = 2; i < totalSeats; i += 2) {
            int prevSecondSeat = seats.get(i - 1);
            int nextFirstSeat = seats.get(i);
            int choices = nextFirstSeat - prevSecondSeat;
            ways = (ways * choices) % MOD;
        }

        return (int) ways;
        
    }
}