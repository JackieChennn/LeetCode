class Solution {
    private final int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, m, n, start, destination, visited);
    }

    private boolean dfs(int[][]maze, int m, int n, int[] curr, int[] destination, boolean[][] visited) {
        if (visited[curr[0]][curr[1]]) {
            return false;
        }
        if (curr[0] == destination[0] && curr[1] == destination[1]) {
            return true;
        }
        visited[curr[0]][curr[1]] = true;
        for (int[] dir : dirs) {
            int x = curr[0];
            int y = curr[1];
            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
            }
            if (dfs(maze, m, n, new int[]{x - dir[0], y - dir[1]}, destination, visited)) {
                return true;
            }
        }
        return false;
    }
}