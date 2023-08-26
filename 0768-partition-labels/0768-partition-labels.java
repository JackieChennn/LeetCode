class Solution {
    public List<Integer> partitionLabels(String s) {
        Set<Character> hs = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int start = 0;
        int end = -1;
        char currChar;
        for (int i = 0; i < n; i++) {
            if (i == end) {
                result.add(end - start + 1);
                hs.clear();
                continue;
            }
            currChar = s.charAt(i);
            if (!hs.isEmpty()) {
                if (hs.contains(currChar)) {
                    continue;
                } else {
                    end = Math.max(end, s.lastIndexOf(currChar));
                }
            } else {
                start = i;
                end = s.lastIndexOf(currChar);
                if (start == end) {
                    result.add(1);
                    continue;
                }
                hs.add(currChar);
            }
            if (end == n - 1) {
                result.add(end - start + 1);
                break;
            }
        }
        return result;
    }
}