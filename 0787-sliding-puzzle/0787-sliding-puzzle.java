class Solution {
    private final int[][] dirs = new int[][] {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        StringBuilder state = new StringBuilder();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                state.append(board[i][j]);
            }
        }
        Map<String, Integer> hm = new HashMap<>();
        dfs(state.toString(), hm, state.indexOf("0"), 0);
        return hm.getOrDefault("123450", -1);
    }

    private void dfs(String state, Map<String, Integer> hm, int currPosition, int moveCount) {
        if (hm.containsKey(state) && hm.get(state) <= moveCount) {
            return;
        }
        hm.put(state, moveCount);
        for (int nextStep : dirs[currPosition]) {
            String newState = swap(state, currPosition, nextStep);
            dfs(newState, hm, nextStep, moveCount + 1);
        }
    }

    private String swap(String state, int x, int y) {
        StringBuilder sb = new StringBuilder(state);
        sb.setCharAt(x, state.charAt(y));
        sb.setCharAt(y, state.charAt(x));
        return sb.toString();
    }
}