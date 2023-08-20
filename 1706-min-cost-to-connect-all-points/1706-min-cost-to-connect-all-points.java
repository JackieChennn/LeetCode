import java.util.AbstractMap.SimpleEntry;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<SimpleEntry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        boolean[] inMST = new boolean[n];
        pq.add(new SimpleEntry<>(0, 0));
        int mstCost = 0;
        int edgesUsed = 0;
        while (edgesUsed < n) {
            SimpleEntry<Integer, Integer> topElement = pq.poll();
            int weight = topElement.getKey();
            int currNode = topElement.getValue();
            if (inMST[currNode]) {
                continue;
            }
            inMST[currNode] = true;
            mstCost += weight;
            edgesUsed++;

            for (int nextNode = 0; nextNode < n; nextNode++) {
                // If next node is not in MST, then edge from curr node to next node can be pushed in the priority queue.
                if (!inMST[nextNode]) {
                    int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
                                     Math.abs(points[currNode][1] - points[nextNode][1]);
                    pq.add(new SimpleEntry<>(nextWeight, nextNode));
                }
            }
        }
        return mstCost;
    }
}