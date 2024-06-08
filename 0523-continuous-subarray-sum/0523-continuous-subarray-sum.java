class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // prefixMod -> first index it appears
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int prefixMod = 0;
        for (int i = 0; i < n; ++i) {
            prefixMod = (prefixMod + nums[i]) % k;
            if (!hm.containsKey(prefixMod)) {
                hm.put(prefixMod, i);
            } else if (i - hm.get(prefixMod) > 1) {
                return true;
            }
        }
        return false;
    }
}