class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        // lis: Longest Increasing Subsequence, lis[i] = x, means x is the length of LIS that ends at index i
        int[] lis = new int[n];
        // lds: Longest Decreasing Subsequence, lis[i] = x, means x is the length of LDS that starts at index i
        int[] lds = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        for (int i = 0; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        int minRemovals = Integer.MAX_VALUE;
        // assume index i is the peak, i cannot at the edge of the array
        for (int i = 1; i < n - 1; ++i) {
            if (lis[i] > 1 && lds[i] > 1) {
                // removals = (i + 1 - lis[i]) + (n - i - lds[i]) = n - lis[i] - lds[i] + 1
                minRemovals = Math.min(minRemovals, n - lis[i] - lds[i] + 1);
            }
        }
        return minRemovals;
    }
}