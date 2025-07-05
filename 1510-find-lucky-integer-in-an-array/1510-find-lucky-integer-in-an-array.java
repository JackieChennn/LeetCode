class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        int res = -1;
        for (int k : freq.keySet()) {
            if (k == freq.get(k) && k > res) {
                res = k;
            }
        }
        return res;
    }
}