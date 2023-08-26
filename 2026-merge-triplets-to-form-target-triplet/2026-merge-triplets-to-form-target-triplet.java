class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] result = new int[3];
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                result = new int[]{Math.max(result[0],triplet[0]), Math.max(result[1],triplet[1]), Math.max(result[2],triplet[2])};
            }
        }
        return Arrays.equals(result, target);
    }
}