class Solution {
    private final static int INF = (int) 2e9;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            if (edge[2] > 0) {
                adjacencyList[edge[0]].add(new int[] {edge[1], edge[2]});
                adjacencyList[edge[1]].add(new int[] {edge[0], edge[2]});
            }
        }
        int currShortestDistance = dijkstraHelper(source, destination, adjacencyList, n);
        if (currShortestDistance < target) {
            return new int[0][0];
        }
        boolean matchFlag = currShortestDistance == target;
        for (int[] edge : edges) {
            if (edge[2] > 0) {
                continue;
            }
            edge[2] = matchFlag ? INF : 1;
            adjacencyList[edge[0]].add(new int[] {edge[1], edge[2]});
            adjacencyList[edge[1]].add(new int[] {edge[0], edge[2]});
            if (!matchFlag) {
                int newDistance = dijkstraHelper(source, destination, adjacencyList, n);
                if (newDistance <= target) {
                    matchFlag = true;
                    edge[2] = edge[2] + (target - newDistance);
                }
            }
        }
        return matchFlag ? edges : new int[0][0];
    }

    private int dijkstraHelper(int source, int destination, List<int[]>[] adjacencyList, int n) {
        int[] minDistance = new int[n];
        boolean[] visited = new boolean[n];
        // pq -> (node#, this node's shortest distance to source)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(minDistance, INF);
        minDistance[source] = 0;
        pq.add(new int[] {source, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];
            // if (distance > minDistance[node]) {
            //     continue;
            // }
            for (int[] neighborInfo : adjacencyList[node]) {
                int neighbor = neighborInfo[0];
                int weight = neighborInfo[1];
                if (distance + weight < minDistance[neighbor]) {
                    minDistance[neighbor] = distance + weight;
                    pq.add(new int[] {neighbor, minDistance[neighbor]});
                }
            }
        }
        return minDistance[destination];
    }
}