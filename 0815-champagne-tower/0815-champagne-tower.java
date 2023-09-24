class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if (poured == 0) {
            return 0.0;
        }
        double[][] dp = new double[query_row + 1][query_row + 1];
        dp[0][0] = ((double) poured - 1.0) / 2;
        for (int row = 1; row <= query_row; row++) {
            dp[row][0] = Math.max(0, (dp[row - 1][0] - 1) / 2);
            for (int glass = 1; glass < row; glass++) {
                dp[row][glass] = Math.max(0, (dp[row - 1][glass - 1] + dp[row - 1][glass] - 1) / 2);
            }
            dp[row][row] = Math.max(0, (dp[row - 1][row - 1] - 1) / 2);
        }
        if (query_row == 0) {
            return Math.min((double)poured, 1.0);
        }
        if (query_glass == 0) {
            return Math.min(dp[query_row - 1][query_glass], 1.0);
        } else if (query_glass == query_row) {
            return Math.min(dp[query_row - 1][query_row - 1], 1.0);
        } else {
            return Math.min(dp[query_row - 1][query_glass - 1] + dp[query_row - 1][query_glass], 1.0);
        }
    }
}