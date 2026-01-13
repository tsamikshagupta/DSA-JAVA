class Solution {
     static class Event {
        long y;
        long delta; 
        Event(long y, long delta) {
            this.y = y;
            this.delta = delta;
        }
    }
    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        double totalArea = 0.0;
        for (int[] sq : squares) {
            long y = sq[1];
            long l = sq[2];
            totalArea += (double) l * l;
            events.add(new Event(y, +l));
            events.add(new Event(y + l, -l));
        }

        double target = totalArea / 2.0;
        events.sort(Comparator.comparingLong(e -> e.y));
        double currentArea = 0.0;
        double currentSlope = 0.0;
        long prevY = events.get(0).y;
        int i = 0;
        while (i < events.size()) {
            long currY = events.get(i).y;
            double deltaY = currY - prevY;
            if (deltaY > 0) {
                double areaGain = currentSlope * deltaY;
                if (currentArea + areaGain >= target) {
                    double needed = target - currentArea;
                    return prevY + needed / currentSlope;
                }
                currentArea += areaGain;
                prevY = currY;
            }
            while (i < events.size() && events.get(i).y == currY) {
                currentSlope += events.get(i).delta;
                i++;
            }
        }

        return prevY;
        
    }
}