class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        // Add index to edges for tracking
        int[][] edgesWithIndex = new int[m][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                edgesWithIndex[i][j] = edges[i][j];
            }
            edgesWithIndex[i][3] = i;
        }
        // Sort edges based on weight
        Arrays.sort(edgesWithIndex, (a, b) -> a[2] - b[2]);

        // Find MST weight using Kruskal's Algo
        DisjointSet dsStd = new DisjointSet(n);
        int stdWeight = 0;
        for (int[] edge : edgesWithIndex) {
            if (dsStd.Union(edge[0], edge[1])) {
                stdWeight += edge[2]; 
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            result.add(new ArrayList<>());
        }

        // Check each edge for critical and pseudo-critical
        for (int i = 0; i < m; i++) {
            // Ignore this edge and calculate MST weight
            DisjointSet dsIgnore = new DisjointSet(n);
            int ignoreWeight = 0;
            for (int j = 0; j < m; j++) {
                if (i != j && dsIgnore.Union(edgesWithIndex[j][0], edgesWithIndex[j][1])) {
                    ignoreWeight += edgesWithIndex[j][2];
                }
            }
            // If the graph is disconnected or the total weight is greater, the edge is critical
            if (dsIgnore.maxSize < n || ignoreWeight > stdWeight) {
                result.get(0).add(edgesWithIndex[i][3]);
            } else {
                // if an edge is not critical, then check whether it is pseudo-critical
                DisjointSet dsForce = new DisjointSet(n);
                dsForce.Union(edgesWithIndex[i][0], edgesWithIndex[i][1]);
                int forceWeight = edgesWithIndex[i][2];
                for (int j = 0; j < m; j++) {
                    if (i != j && dsForce.Union(edgesWithIndex[j][0], edgesWithIndex[j][1])) {
                        forceWeight += edgesWithIndex[j][2];
                    }
                }
                // If total weight is the same, the edge is pseudo-critical
                if (forceWeight == stdWeight) {
                    result.get(1).add(edgesWithIndex[i][3]);
                }
            }
        }
        return result;
    }
}

class DisjointSet {
    int[] parent;
    int[] size;
    int maxSize;

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        maxSize = 1;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        // Finds the root of x
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean Union(int x, int y) {
        // Connects x and y
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                int temp = rootX;
                rootX = rootY;
                rootY = temp;
            }
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
            maxSize = Math.max(maxSize, size[rootX]);
            return true;
        }
        return false;
    }
}