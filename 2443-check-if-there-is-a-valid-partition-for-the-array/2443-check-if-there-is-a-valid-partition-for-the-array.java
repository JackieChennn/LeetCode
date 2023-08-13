class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return isValid(nums, 0, 1);
        } else if (n == 3) {
            return isValid(nums, 0, 2);
        } else if (n == 4) {
            return isValid(nums, 0, 1) && isValid(nums, 2, 3);
        }
        // dp[i] represent the numbers from index 0 to i is valid or not.
        boolean[] dp = new boolean[n];
        dp[1] = isValid(nums, 0, 1);
        dp[2] = isValid(nums, 0, 2);
        dp[3] = isValid(nums, 0, 1) && isValid(nums, 2, 3);
        for (int i = 4; i < n; i++) {
            dp[i] = dp[i - 3] && isValid(nums, i - 2, i) || dp[i - 2] && isValid(nums, i - 1, i);
        }
        return dp[n - 1];
    }

    // only take end - start == 1 or 2.
    private boolean isValid(int[] nums, int start, int end) {
        if (end - start == 1) {
            return nums[start] == nums[end];
        } else if (end - start == 2) {
            if (nums[start] == nums[start + 1] && nums[start + 1] == nums[end]) {
                return true;
            } else if (nums[end] - nums[start + 1] == 1 && nums[start + 1] - nums[start] == 1) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}