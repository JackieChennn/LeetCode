class Solution {

    private final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        // {time, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {grid[0][0], 0, 0});
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int time = cell[0];
            int x = cell[1];
            int y = cell[2];
            if (x == m - 1 && y == n - 1) {
                return time;
            }
            if (visited[x][y] == 1) {
                continue;
            }
            visited[x][y] = 1;
            for (int[] dir : dirs) {
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && visited[nextX][nextY] == 0) {
                    int waitTime = ((grid[nextX][nextY] - time) % 2 == 0) ? 1 : 0;
                    int nextTime = Math.max(grid[nextX][nextY] + waitTime, time + 1);
                    pq.add(new int[] {nextTime, nextX, nextY});
                }
            }
        }
        return -1;
    }
}