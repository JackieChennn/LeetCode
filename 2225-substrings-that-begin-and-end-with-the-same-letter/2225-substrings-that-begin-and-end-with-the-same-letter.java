class Solution {
    public long numberOfSubstrings(String s) {
        long[] counts = new long[26];
        for (char ch : s.toCharArray()) {
            ++counts[ch - 'a'];
        }
        long result = 0;
        for (long count : counts) {
            result += (count + 1) * count / 2;
        }
        return result;
    }
}