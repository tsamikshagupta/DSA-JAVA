import java.util.*;

class Solution {
    static class Event {
        long y, x1, x2;
        int type;
        Event(long y, long x1, long x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int n;
        int[] cover;
        long[] length;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            cover = new int[4 * Math.max(1, n)];
            length = new long[4 * Math.max(1, n)];
        }

        void update(int l, int r, int val) {
            if (l <= r) update(1, 0, n - 1, l, r, val);
        }

        long query() {
            return n == 0 ? 0 : length[1];
        }

        private void update(int node, int start, int end, int l, int r, int val) {
            if (l <= start && end <= r) {
                cover[node] += val;
                pull(node, start, end);
                return;
            }
            int mid = (start + end) / 2;
            if (l <= mid) update(node * 2, start, mid, l, r, val);
            if (r > mid) update(node * 2 + 1, mid + 1, end, l, r, val);
            pull(node, start, end);
        }

        private void pull(int node, int start, int end) {
            if (cover[node] > 0) {
                length[node] = xs[end + 1] - xs[start];
            } else {
                length[node] = (start == end) ? 0 : length[node * 2] + length[node * 2 + 1];
            }
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;
        Event[] events = new Event[2 * n];
        long[] xCoords = new long[2 * n];

        int idx = 0;
        for (int[] s : squares) {
            long x = s[0], y = s[1], l = s[2];
            events[idx] = new Event(y, x, x + l, 1);
            events[idx + 1] = new Event(y + l, x, x + l, -1);
            xCoords[idx] = x;
            xCoords[idx + 1] = x + l;
            idx += 2;
        }

        Arrays.sort(xCoords);
        xCoords = Arrays.stream(xCoords).distinct().toArray();
        Arrays.sort(events, Comparator.comparingLong(e -> e.y));

        double totalArea = computeArea(events, xCoords);
        double half = totalArea / 2.0;

        return findSplit(events, xCoords, half);
    }

    private double computeArea(Event[] events, long[] xs) {
        SegmentTree st = new SegmentTree(xs);
        double area = 0;
        long prevY = events[0].y;
        long width = 0;
        int i = 0;
        while (i < events.length) {
            long y = events[i].y;
            area += width * (y - prevY);
            while (i < events.length && events[i].y == y) {
                int l = Arrays.binarySearch(xs, events[i].x1);
                int r = Arrays.binarySearch(xs, events[i].x2) - 1;
                st.update(l, r, events[i].type);
                i++;
            }
            width = st.query();
            prevY = y;
        }
        return area;
    }

    private double findSplit(Event[] events, long[] xs, double half) {
        SegmentTree st = new SegmentTree(xs);
        double area = 0;
        long prevY = events[0].y;
        long width = 0;
        int i = 0;
        while (i < events.length) {
            long y = events[i].y;
            double strip = width * (y - prevY);

            if (area + strip >= half && width > 0) {
                return prevY + (half - area) / width;
            }
            area += strip;
            while (i < events.length && events[i].y == y) {
                int l = Arrays.binarySearch(xs, events[i].x1);
                int r = Arrays.binarySearch(xs, events[i].x2) - 1;
                st.update(l, r, events[i].type);
                i++;
            }
            width = st.query();
            prevY = y;
        }
        return prevY;
    }
}
