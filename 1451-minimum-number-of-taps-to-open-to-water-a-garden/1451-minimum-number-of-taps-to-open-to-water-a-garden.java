class Solution {
    public int minTaps(int n, int[] ranges) {
        // reach[left] = right
        int[] reach = new int[n + 1];
        Arrays.fill(reach, 0);
        for (int i = 0; i <= n; i++) {
            if (ranges[i] > 0) {
                int left = Math.max(0, i - ranges[i]);
                reach[left] = Math.max(reach[left], i + ranges[i]);
            }
        }
        // number of taps opened
        int count = 0;
        // the last point that can be watered by tap
        int end = 0;
        // the farest point the can be watered by tap
        int far_can_reach = 0;
        for (int i = 0; i <= n; i++) {
            if (i > end) {
                if (far_can_reach <= end) {
                    // means at least [end, end + 1] is not covered.
                    return -1;
                } else {
                    // means now we need to open a new tap
                    // extend end to far_can_reach
                    end = far_can_reach;
                    // open the tap which can reach the far_can_reach
                    count++;
                }
            }
            // record the far_can_reach
            far_can_reach = Math.max(far_can_reach, reach[i]);
        }
        // if end is still < n, means we still need one more tap.
        return count + (end < n ? 1 : 0);
    }
}