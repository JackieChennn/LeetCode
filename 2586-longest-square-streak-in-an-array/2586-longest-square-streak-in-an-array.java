class Solution {
    public int longestSquareStreak(int[] nums) {
        // last number -> streak
        Map<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(nums);
        int root = 0;
        for (int num : nums) {
            root = (int) Math.sqrt(num);
            if (root * root == num && hm.containsKey(root)) {
                hm.put(num, hm.get(root) + 1);
            } else {
                hm.put(num, 1);
            }
        }
        int maxLen = -1;
        for (int len : hm.values()) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen == 1 ? -1 : maxLen;
    }
}