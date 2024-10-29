class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        for (int i = n - 2; i >= 0; --i) {
            int minColor = -1;
            int secondMinColor = -1;
            for (int j = 0; j < k; ++j) {
                if (minColor == -1 || costs[i + 1][j] < costs[i + 1][minColor]) {
                    secondMinColor = minColor;
                    minColor = j;
                } else if (secondMinColor == -1 || costs[i + 1][j] < costs[i + 1][secondMinColor]) {
                    secondMinColor = j;
                }
            }
            for (int j = 0; j < k; ++j) {
                if (j == minColor) {
                    costs[i][j] += costs[i + 1][secondMinColor];
                } else {
                    costs[i][j] += costs[i + 1][minColor];
                }
            }
        }
        return IntStream.of(costs[0]).min().getAsInt();
    }
}