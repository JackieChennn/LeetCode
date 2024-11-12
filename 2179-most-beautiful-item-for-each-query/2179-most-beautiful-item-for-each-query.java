class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int m = items.length;
        int res[] = new int[n];
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int max = items[0][1];
        for (int i = 0; i < m; ++i) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }
        TreeMap<Integer, PriorityQueue<Integer>> tm = new TreeMap<>();
        for (int[] item : items) {
            PriorityQueue<Integer> pq = tm.getOrDefault(item[0], new PriorityQueue<>((a, b) -> b - a));
            pq.add(item[1]);
            tm.put(item[0], pq);
        }
        for (int i = 0; i < n; ++i) {
            Integer key = tm.floorKey(queries[i]);
            res[i] = (key != null) ? tm.get(key).peek() : 0;
        }
        return res;
    }
}