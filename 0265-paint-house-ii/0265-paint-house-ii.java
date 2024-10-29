class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < k; ++j) {
                int min = Integer.MAX_VALUE;
                for (int h = 0; h < k; ++h) {
                    if (h != j) {
                        min = Math.min(min, costs[i + 1][h]);
                    }
                }
                costs[i][j] += min;
            }
        }
        return IntStream.of(costs[0]).min().getAsInt();
    }
}