    class Solution {
        public int change(int amount, int[] coins) {
            if (amount == 0) {
                return 1;
            }
            Arrays.sort(coins);
            int n = coins.length;
            int[][] dp = new int[amount + 1][n];
            for (int i = 0; i <= amount; i += 1) {
                if (i != 0 && i % coins[0] == 0) {
                    dp[i][0] = 1;
                } else {
                    dp[i][0] = 0;
                }
            }
            for (int j = 1; j < n; j += 1) {
                dp[0][j] = 0;
                for (int k = 1; k <= amount; k += 1) {
                    if (k > coins[j]) {
                        dp[k][j] = dp[k - coins[j]][j] + dp[k][j - 1];
                    } else if (k == coins[j]) {
                        dp[k][j] = 1 + dp[k][j - 1];
                    } else {
                        dp[k][j] = dp[k][j - 1];
                    }
                }
            }
            return dp[amount][n - 1];
        }
    }