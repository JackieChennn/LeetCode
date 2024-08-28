class Solution {
    private final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean isCellLand(int x, int y, int[][] grid) {
        return grid[x][y] == 1;
    }

    private boolean isSubIsland(int x, int y, int[][] grid1, int[][] grid2, boolean[][] visited) {
        int m = grid2.length;
        int n = grid2[0].length;

        boolean result = true;

        Queue<int[]> pendingCells = new LinkedList<>();
        pendingCells.offer(new int[] { x, y });
        visited[x][y] = true;
        while (!pendingCells.isEmpty()) {
            int[] curr = pendingCells.poll();
            int currX = curr[0];
            int currY = curr[1];
            if (!isCellLand(currX, currY, grid1)) {
                result = false;
            }

            for (int[] direction : dirs) {
                int nextX = currX + direction[0];
                int nextY = currY + direction[1];
                if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n && !visited[nextX][nextY] && isCellLand(nextX, nextY, grid2)) {
                    pendingCells.offer(new int[] { nextX, nextY });
                    visited[nextX][nextY] = true;
                }
            }
        }
        return result;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;
        boolean[][] visited = new boolean[m][n];
        int subIslandCounts = 0;
        for (int x = 0; x < m; ++x) {
            for (int y = 0; y < n; ++y) {
                if (!visited[x][y] && isCellLand(x, y, grid2) && isSubIsland(x, y, grid1, grid2, visited)) {
                    subIslandCounts += 1;
                }
            }
        }
        return subIslandCounts;
    }
}