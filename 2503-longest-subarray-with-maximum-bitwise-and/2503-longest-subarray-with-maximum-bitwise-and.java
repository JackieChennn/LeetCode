class Solution {
    public int longestSubarray(int[] nums) {
        int maxNum = -1;
        int currentStreak = 0;
        int res = 0;
        for (int num : nums) {
            if (num > maxNum) {
                maxNum = num;
                currentStreak = 1;
                res = 1;
            } else if (num == maxNum) {
                currentStreak++;
            } else {
                currentStreak = 0;
            }
            res = Math.max(res, currentStreak);
        }
        return res;
    }
}