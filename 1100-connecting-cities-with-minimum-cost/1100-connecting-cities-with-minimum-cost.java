class Solution {
    public int minimumCost(int n, int[][] connections) {
        DisjointSet disjointSet = new DisjointSet(n);
        // Sort connections based on their weights (in increasing order)
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        // Keep track of total edges added in the MST
        int total = 0;
        // Keep track of the total cost of adding all those edges
        int cost = 0;
        for (int i = 0; i < connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            // if a and b is already connected, skip
            if (disjointSet.isInSameGroup(a, b)) {
                continue;
            }
            disjointSet.Union(a, b);
            cost += connections[i][2];
            total++;
        }
        return (total == n - 1) ? cost : -1;
    }
}

class DisjointSet {
    private int[] weights;
    private int[] parents;

    public DisjointSet(int N) {
        this.parents = new int[N + 1];
        this.weights = new int[N + 1];
        // Set the initial parent node to itself
        for (int i = 1; i <= N; i++) {
            this.parents[i] = i;
            this.weights[i] = 1;
        }
    }

    // Path compression
    public int Find(int a) {
        // Traverse all the way to the top (root) going through the parent nodes
        while (a != this.parents[a]) {
            // a's grandparent is now a's parent
            this.parents[a] = this.parents[parents[a]];
            a = this.parents[a];
        }
        return a;
    }

    // Weighted union
    public void Union(int a, int b) {
        int rootA = Find(a);
        int rootB = Find(b);
        if (rootA == rootB) {
            return;
        }

        if (this.weights[rootA] > this.weights[rootB]) {
            this.parents[rootB] = rootA;
            this.weights[rootA] += this.weights[rootB];
        } else {
            this.parents[rootA] = rootB;
            this.weights[rootB] += this.weights[rootA];
        }
    }

    public boolean isInSameGroup(int a, int b) {
        // Return true if both a and b belong to the same set, otherwise return false
        return Find(a) == Find(b);
    }
}