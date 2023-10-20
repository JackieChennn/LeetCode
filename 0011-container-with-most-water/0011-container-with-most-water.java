class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = -1;
        int waterAmount = 0;
        while (left < right) {
            waterAmount = Math.min(height[left], height[right]) * (right - left);
            if (waterAmount > result) {
                result = waterAmount;
            }
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return result;
    }
}