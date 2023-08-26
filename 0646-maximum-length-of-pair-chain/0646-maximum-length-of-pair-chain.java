class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int currTail = -1001;
        int result = 0;
        for (int[] pair : pairs) {
            if (pair[0] > currTail) {
                result++;
                currTail = pair[1];
            }
        }
        return result;
    }
}