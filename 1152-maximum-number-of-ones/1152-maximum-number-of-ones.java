class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                pq.add(countCells(width, height, sideLength, i, j));
            }
        }
        int result = 0;
        for (int i = 0; i < maxOnes; i++) {
            result += pq.poll();
        }
        return result;
    }

    private int countCells(int width, int height, int sideLength, int x, int y) {
        return ceilDiv((width - x), sideLength) * ceilDiv((height - y), sideLength);
    }

    private int ceilDiv(int x, int y) {
        if (x % y == 0) {
            return x / y;
        } else {
            return x / y + 1;
        }
    }
}