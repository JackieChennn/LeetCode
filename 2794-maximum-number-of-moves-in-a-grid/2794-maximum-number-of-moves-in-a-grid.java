class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j] = x, the max moves end at (i, j) is x moves.
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 0;
        }
        int maxMove = 0;
        for (int col = 1; col < n; ++col) {
            for (int row = 0; row < m; ++row) {
                if (grid[row][col] > grid[row][col - 1] && dp[row][col - 1] != null) {
                    if (dp[row][col] != null) {
                        dp[row][col] = Math.max(dp[row][col], dp[row][col - 1] + 1);
                    } else {
                        dp[row][col] = dp[row][col - 1] + 1;
                    }
                }
                if (row - 1 >= 0 && grid[row][col] > grid[row - 1][col - 1] && dp[row - 1][col - 1] != null) {
                    if (dp[row][col] != null) {
                        dp[row][col] = Math.max(dp[row][col], dp[row - 1][col - 1] + 1);
                    } else {
                        dp[row][col] = dp[row - 1][col - 1] + 1;
                    }
                }
                if (row + 1 < m && grid[row][col] > grid[row + 1][col - 1] && dp[row + 1][col - 1] != null) {
                    if (dp[row][col] != null) {
                        dp[row][col] = Math.max(dp[row][col], dp[row + 1][col - 1] + 1);
                    } else {
                        dp[row][col] = dp[row + 1][col - 1] + 1;
                    }
                }
                if (dp[row][col] != null) {
                    maxMove = Math.max(maxMove, dp[row][col]);
                }
            }
        }
        return maxMove;
    }
}