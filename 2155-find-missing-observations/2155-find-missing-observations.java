class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int diff = 0;
        for (int roll : rolls) {
            diff += roll - mean;
        }
        int sum = mean * n - diff;
        if (sum < n || sum > 6 * n) {
            return new int[0];
        }
        int[] res = new int[n];
        Arrays.fill(res, 1);
        sum -= n;
        int i = 0;
        while (sum > 0) {
            if (sum > 5) {
                res[i] = 6;
                sum -= 5;
            } else {
                res[i] = sum + 1;
                sum = 0;
            }
            ++i;
        }
        return res;
    }
}