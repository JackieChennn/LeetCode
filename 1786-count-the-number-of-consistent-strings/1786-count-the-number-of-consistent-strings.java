class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> hs = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            hs.add(ch);
        }
        int count = 0;
        boolean consistentFlag;
        for (String word : words) {
            consistentFlag = true;
            for (char ch : word.toCharArray()) {
                if (!hs.contains(ch)) {
                    consistentFlag = false;
                    break;
                }
            }
            if (consistentFlag) {
                ++count;
            }
        }
        return count;
    }
}