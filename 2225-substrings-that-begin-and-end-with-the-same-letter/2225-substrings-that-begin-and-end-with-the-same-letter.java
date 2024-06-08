class Solution {
    public long numberOfSubstrings(String s) {
        // letter -> frequency
        Map<Character, Long> hm = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0L) + 1);
        }
        long result = 0;
        for (long count : hm.values()) {
            result += (count + 1) * count / 2;
        }
        return result;
    }
}