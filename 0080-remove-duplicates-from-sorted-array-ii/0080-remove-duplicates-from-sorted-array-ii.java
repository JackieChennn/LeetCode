class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int index = 2;
        for (int i = 2; i < n; i++) {
            nums[index] = nums[i];
            if (nums[index] != nums[index - 2]) {
                index++;
            }
        }
        return index;
    }
}