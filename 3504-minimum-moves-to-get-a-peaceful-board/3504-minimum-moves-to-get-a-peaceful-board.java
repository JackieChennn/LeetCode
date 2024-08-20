class Solution {
    public int minMoves(int[][] rooks) {
        int n = rooks.length;
        int res = 0;
        Arrays.sort(rooks, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; ++i) {
            res += Math.abs(i - rooks[i][0]);
        }
        Arrays.sort(rooks, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; ++i) {
            res += Math.abs(i - rooks[i][1]);
        }
        return res;
    }
}