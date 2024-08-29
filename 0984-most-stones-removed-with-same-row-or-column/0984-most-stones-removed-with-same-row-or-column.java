class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; ++i) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjacencyList[i].add(j);
                    adjacencyList[j].add(i);
                }
            }
        }
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                dfs(i, adjacencyList, visited);
                ++count;
            }
        }
        return n - count;
    }

    private void dfs(int i, List<Integer>[] adjacencyList, int[] visited) {
        visited[i] = 1;
        for (int neighbour : adjacencyList[i]) {
            if (visited[neighbour] == 0) {
                dfs(neighbour, adjacencyList, visited);
            }
        }
    }
}