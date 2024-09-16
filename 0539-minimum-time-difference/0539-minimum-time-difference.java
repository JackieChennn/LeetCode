class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] min = new int[n];
        for (int i = 0; i < n; ++i) {
            String[] hourAndMinute = timePoints.get(i).split(":");
            min[i] = Integer.parseInt(hourAndMinute[0]) * 60 + Integer.parseInt(hourAndMinute[1]);
        }
        Arrays.sort(min);
        int res = min[1] - min[0];
        for (int i = 2; i < n; ++i) {
            res = Math.min(res, min[i] - min[i - 1]);
        }
        res = Math.min(res, 1440 - min[n - 1] + min[0]);
        return res;
    }
}