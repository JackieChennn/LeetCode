class Solution {
    private int n;
    public int stoneGameII(int[] piles) {
        this.n = piles.length;
        int[][] memo = new int[n][n];
        int[] suffixSum = Arrays.copyOf(piles, n);
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1];
        }
        return helper(suffixSum, 1, 0, memo);
    }

    private int helper(int[] suffixSum, int maxTillNow, int currIndex, int[][] memo) {
        if (currIndex + 2 * maxTillNow >= n) {
            return suffixSum[currIndex];
        }
        if (memo[currIndex][maxTillNow] > 0) {
            return memo[currIndex][maxTillNow];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * maxTillNow; ++i) {
            res = Math.min(res, helper(suffixSum, Math.max(i, maxTillNow), currIndex + i, memo));
        }
        memo[currIndex][maxTillNow] = suffixSum[currIndex] - res;
        return memo[currIndex][maxTillNow];
    }
}