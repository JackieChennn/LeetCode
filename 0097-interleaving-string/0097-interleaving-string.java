class Solution {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        memo = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return dp(s1, s2, s3, 0, 0, 0);
    }

    private boolean dp(String s1, String s2, String s3, int p1, int p2, int p3) {
        if (p1 == s1.length()) {
            return s2.substring(p2).equals(s3.substring(p3));
        } else if (p2 == s2.length()) {
            return s1.substring(p1).equals(s3.substring(p3));
        }
        if (memo[p1][p2] >= 0) {
            return memo[p1][p2] == 1 ? true : false;
        }
        boolean ans = false;
        if (s3.charAt(p3) == s1.charAt(p1) && dp(s1, s2, s3, p1 + 1, p2, p3 + 1)
        || s3.charAt(p3) == s2.charAt(p2) && dp(s1, s2, s3, p1, p2 + 1, p3 + 1)) {
            ans = true;
        }
        memo[p1][p2] = ans ? 1 : 0;
        return ans;
    }
}