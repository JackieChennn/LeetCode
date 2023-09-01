class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int currNum = 0;
        int calculateTill = 1;

        while (calculateTill <= n) {
            while (currNum < calculateTill && currNum + calculateTill <= n) {
                ans[currNum + calculateTill] = ans[currNum] + 1;
                currNum += 1;
            }
            currNum = 0;
            calculateTill <<= 1;
        }
        return ans;
    }
}