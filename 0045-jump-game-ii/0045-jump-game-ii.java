  class Solution {

    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE - 100000);
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i -= 1) {

            for (int j = i + 1; j <= i + nums[i] && j < n; j += 1) {
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[0];
    }
  }