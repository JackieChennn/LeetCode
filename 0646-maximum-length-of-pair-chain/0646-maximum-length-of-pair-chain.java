class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 1) {
            return 1;
        }
        // dp[i] is the longest length of chain starting from the i-th pair
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int result = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }
}