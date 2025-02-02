class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return true;
        }
        int increaseTime = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > nums[i]) {
                if (++increaseTime > 1) {
                    return false;
                }
            }
        }
        if (increaseTime == 1) {
            return nums[0] >= nums[n - 1];
        } else {
            return true;
        }
    }
}