import java.util.AbstractMap.SimpleEntry;
class Solution {
    private static final int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Deque<SimpleEntry<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new SimpleEntry<>(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            Deque<SimpleEntry<Integer, Integer>> newQueue = new LinkedList<>();
            distance++;
            while (!queue.isEmpty()) {
                SimpleEntry<Integer, Integer> entry = queue.poll();
                for (int[] dir : dirs) {
                    int x = entry.getKey() + dir[0];
                    int y = entry.getValue() + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (!visited[x][y]) {
                        newQueue.add(new SimpleEntry(x, y));
                        visited[x][y] = true;
                        result[x][y] = distance;
                    }
                }
            }
            queue = newQueue;
        }
        return result;
    }
}