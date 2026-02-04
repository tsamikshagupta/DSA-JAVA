class Solution {
    public long maxSumTrionic(int[] nums) {
        long NEG = Long.MIN_VALUE / 4;

        long inc1 = nums[0];
        long inc2 = NEG;
        long dec = NEG;
        long tri2 = NEG;

        long ans = NEG;

        for (int i = 1; i < nums.length; i++) {
            long x = nums[i];

            long nInc1, nInc2, nDec, nTri2;

            if (nums[i - 1] < nums[i]) {
                nInc1 = Math.max(x, inc1 + x);
                nInc2 = Math.max(inc2 == NEG ? NEG : inc2 + x, inc1 + x);

                long startTri = (dec == NEG) ? NEG : dec + x;
                long extendTri = (tri2 == NEG) ? NEG : tri2 + x;
                nTri2 = Math.max(startTri, extendTri);

                nDec = NEG;
            } else {
                nInc1 = x;
                nInc2 = NEG;
                nTri2 = NEG;

                if (nums[i - 1] > nums[i]) {
                    long startDec = (inc2 == NEG) ? NEG : inc2 + x;
                    long extendDec = (dec == NEG) ? NEG : dec + x;
                    nDec = Math.max(startDec, extendDec);
                } else {
                    nDec = NEG;
                }
            }

            inc1 = nInc1;
            inc2 = nInc2;
            dec = nDec;
            tri2 = nTri2;

            if (tri2 != NEG) ans = Math.max(ans, tri2);
        }

        return ans;
    }
}
