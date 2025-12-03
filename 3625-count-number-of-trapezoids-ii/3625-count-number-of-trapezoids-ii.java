public class Solution {

    static final int BIAS = 1 << 11;  
    static int pack2(int a, int b) {
        long A = (long)(a + BIAS);
        long B = (long)(b + BIAS);
        return (int)((A << 16) | B);
    }


    static long pack3(int a, int b, int c) {
        long A = (long)(a + BIAS);
        long B = (long)(b + BIAS);
        long C = (long)(c + (long)BIAS * BIAS);
        return (A << 50) | (B << 30) | C;
    }

    static long pack4(int a, int b, int c, int d) {
        long A = (long)(a + BIAS);
        long B = (long)(b + BIAS);
        long C = (long)(c + BIAS);
        long D = (long)(d + BIAS);
        return (A << 48) | (B << 32) | (C << 16) | D;
    }

    static int gcd(int a, int b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public int countTrapezoids(int[][] points) {

        int n = points.length;
        int nn = n * (n - 1);
        HashMap<Long, Integer> coeff = new HashMap<>(nn);
        HashMap<Long, Integer> midPointWslope = new HashMap<>(nn);
        HashMap<Integer, Integer> slope = new HashMap<>(nn);
        HashMap<Long, Integer> midPoint = new HashMap<>(nn);

        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            int x0 = points[i][0];
            int y0 = points[i][1];

            for (int j = i + 1; j < n; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];
                int a = y1 - y0;
                int b = x0 - x1;
                int c = y0 * x1 - y1 * x0;
                if (a == 0 && b < 0) {
                    b = -b;
                    c = -c;
                } else if (a < 0) {
                    a = -a;
                    b = -b;
                    c = -c;
                }

                int gm = gcd(a, b);
                int gc = gcd(gm, c);

                int slopeKey = pack2(a / gm, b / gm);
                long lineKey = pack3(a / gc, b / gc, c / gc);

                long mid = pack2(x0 + x1, y0 + y1);
                long midSlope = pack4(x0 + x1, y0 + y1, a / gm, b / gm);

                cnt += slope.getOrDefault(slopeKey, 0);
                slope.put(slopeKey, slope.getOrDefault(slopeKey, 0) + 1);

                cnt -= coeff.getOrDefault(lineKey, 0);
                coeff.put(lineKey, coeff.getOrDefault(lineKey, 0) + 1);

                cnt -= midPoint.getOrDefault(mid, 0);
                midPoint.put(mid, midPoint.getOrDefault(mid, 0) + 1);

                cnt += midPointWslope.getOrDefault(midSlope, 0);
                midPointWslope.put(midSlope, midPointWslope.getOrDefault(midSlope, 0) + 1);
            }
        }

        return cnt;
    }
}
