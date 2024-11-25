class Solution {
    public int[][] minScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // each element in this pq is int[] {grid[i][j], i, j}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                pq.add(new int[] {grid[i][j], i, j});
            }
        }
        int[] rowMax = new int[m];
        int[] colMax = new int[n];
        Arrays.fill(rowMax, 1);
        Arrays.fill(colMax, 1);
        int[] temp;
        int value, x, y;
        while (!pq.isEmpty()) {
            temp = pq.poll();
            value = temp[0];
            x = temp[1];
            y = temp[2];
            grid[x][y] = Math.max(rowMax[x], colMax[y]);
            rowMax[x] = grid[x][y] + 1;
            colMax[y] = grid[x][y] + 1;
        }
        return grid;
    }
}