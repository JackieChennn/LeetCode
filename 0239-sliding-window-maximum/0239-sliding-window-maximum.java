class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        // window will hold the indices of nums
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < n; i += 1) {
            // Out-of-Window Check, if the first index is out of window, remove it
            while (window.size() > 0 && window.getFirst() <= i - k) {
                window.removeFirst();
            }
            // Maintaining Maximum, nums[i] will always smaller than nums[window.getLast()]
            while (window.size() > 0 && nums[window.getLast()] < nums[i]) {
                window.removeLast();
            }
            window.addLast(i);
            if (i >= k - 1) {
                // nums[window.getFirst()] is the largest number in this window
                ans[i - k + 1] = nums[window.getFirst()];
            }
        }
        return ans;
    }
}