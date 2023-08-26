class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] result = new boolean[3];
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                result[0] |= triplet[0] == target[0];
                result[1] |= triplet[1] == target[1];
                result[2] |= triplet[2] == target[2];
            }
        }
        return result[0] && result[1] && result[2];
    }
}