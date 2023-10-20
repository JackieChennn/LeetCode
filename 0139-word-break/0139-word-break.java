class Solution {
    private int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s.length() - 1, s, set);
    }

    private boolean dp(int index, String s, Set<String> set) {
        if (index < 0) {
            return true;
        }

        if (memo[index] != -1) {
            return memo[index] == 1;
        }

        for (String word: set) {
            if (index - word.length() + 1 < 0) {
                continue;
            }
            if (s.substring(index - word.length() + 1, index + 1).equals(word) && dp(index - word.length(), s, set)) {
                memo[index] = 1;
                return true;
            }
        }
        memo[index] = 0;
        return false;
    }
}