class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = chalk[0];
        for (int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + chalk[i];
        }
        long newK = k % prefixSum[n - 1];
        int left = 0;
        int right = n - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (prefixSum[mid] <= newK) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left % n;
    }
}