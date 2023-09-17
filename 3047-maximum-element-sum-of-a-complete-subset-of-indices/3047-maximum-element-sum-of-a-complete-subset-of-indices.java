class Solution {
    public long maximumSum(List<Integer> nums) {
        Map<Long, Long> hm = new HashMap<>();
        long result = 0;
        long key;
        long v;
        /**
        * For each index i,
        * divide it by all possible square number,
        * until the key of i.
        * 
        * For example,
        * Key of 1 is 1
        * Key of 18 is 2
        * Key of 24 is 6
        * 
        * In complete set, all indices have the same key.
         */
        for (int i = 0; i < nums.size(); i++) {
            for (key = i + 1, v = 2; v * v <= key; v++) {
                while (key % (v * v) == 0) {
                    key /= v * v;
                }
            }
            // add up element's with the same key
            hm.put(key, hm.getOrDefault(key, 0l) + (long)nums.get(i));
            result = Math.max(result, hm.get(key));
        }
        return result;
    }
}