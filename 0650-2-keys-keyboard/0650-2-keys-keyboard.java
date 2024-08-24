class Solution {
    private int n;

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        this.n = n;
        int[][] memo = new int[n + 1][n / 2 + 1];
        return 1 + helper(1, 1, memo);
    }

    private int helper(int currLen, int pasteLen, int[][] memo) {
        if (currLen == n) {
            return 0;
        }
        if (currLen > n) {
            return 1000;
        }
        if (memo[currLen][pasteLen] != 0) {
            return memo[currLen][pasteLen];
        }
        int opt1 = 1 + helper(currLen + pasteLen, pasteLen, memo);
        int opt2 = 2 + helper(currLen * 2, currLen, memo);
        memo[currLen][pasteLen] = Math.min(opt1, opt2);
        return memo[currLen][pasteLen];
    }
}