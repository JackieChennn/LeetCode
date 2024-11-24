class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a) - Math.abs(b));
        long sum = 0L;
        int negativeCount = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] < 0) {
                    ++negativeCount;
                }
                sum += Math.abs(matrix[i][j]);
                pq.add(matrix[i][j]);
            }
        }
        if (negativeCount % 2 == 0) {
            return sum;
        }
        int minElement = pq.peek();
        sum -= 2 * Math.abs(minElement);
        return sum;
    }
}