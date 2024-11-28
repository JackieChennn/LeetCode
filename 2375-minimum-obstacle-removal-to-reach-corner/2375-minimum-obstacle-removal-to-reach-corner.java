class Solution {

    private final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] obstacles = new int[m][n];
        for (int[] row : obstacles) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        obstacles[0][0] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[] {0, 0, 0}); // {row, col, obstacles}
        while (!deque.isEmpty()) {
            int[] cell = deque.pollFirst();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && obstacles[x][y] == Integer.MAX_VALUE) {
                    if (grid[x][y] == 1) {
                        obstacles[x][y] = cell[2] + 1;
                        deque.addLast(new int[] {x, y, cell[2] + 1});
                    } else {
                        obstacles[x][y] = cell[2];
                        deque.addFirst(new int[] {x, y, cell[2]});
                    }
                }
            }
        }
        return obstacles[m - 1][n - 1];
    }
}