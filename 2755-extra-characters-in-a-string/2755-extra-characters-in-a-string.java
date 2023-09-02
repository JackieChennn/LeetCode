class Solution {
    private Integer[] memo;
    private HashSet<String> dictionarySet;

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        memo = new Integer[n];
        dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        return dp(0, n, s);
    }

    private int dp(int start, int n, String s) {
        if (start == n) {
            return 0;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        // this char is a left over
        int ans = dp(start + 1, n, s) + 1;

        // check whether this char starts a word in the dictionary
        for (int end = start; end < n; end++) {
            String currWord = s.substring(start, end + 1);
            if (dictionarySet.contains(currWord)) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }
        memo[start] = ans;
        return ans;
    }
}