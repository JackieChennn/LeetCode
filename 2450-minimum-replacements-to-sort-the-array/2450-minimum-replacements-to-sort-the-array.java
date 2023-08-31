class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long count = 0;
        long numElements;
        int curr, next;
        for (int i = n - 2; i >= 0; i--) {
            curr = nums[i];
            next = nums[i + 1];
            if (curr > next) {
                numElements = (long)(curr + next - 1) / (long)next;
                count += numElements - 1;
                nums[i] = nums[i] / (int)numElements;
            }
        }
        return count;
    }
}