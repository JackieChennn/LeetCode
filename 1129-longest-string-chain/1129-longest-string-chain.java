class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> memo = new HashMap<>();
        Set<String> hs = new HashSet<>();
        Collections.addAll(hs, words);
        int result = 0;
        for (String word : words) {
            result = Math.max(result, dfs(hs, memo, word));
        }
        return result;
    }

    private int dfs(Set<String> hs, Map<String, Integer> memo, String currentWord) {
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);
        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if (hs.contains(newWord)) {
                int currentLength = 1 + dfs(hs, memo, newWord);
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, currentWord.charAt(i));
        }
        memo.put(currentWord, maxLength);
        return maxLength;
    }
}