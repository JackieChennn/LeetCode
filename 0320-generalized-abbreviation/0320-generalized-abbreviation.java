class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        backtrack(res, word, new StringBuilder(), 0, 0);
        return res;
    }

    private void backtrack(List<String> res, String word, StringBuilder currWord, int index, int count) {
        if (index == word.length()) {
            if (count > 0) {
                currWord.append(count);
            }
            res.add(currWord.toString());
            return;
        }
        int currLength = currWord.length();
        // Option 1: Keep the current char
        if (count > 0) {
            currWord.append(count);
        }
        currWord.append(word.charAt(index));
        backtrack(res, word, currWord, index + 1, 0);
        currWord.setLength(currLength);
        // Option 2: Abbreviate the current char
        backtrack(res, word, currWord, index + 1, count + 1);
    }
}