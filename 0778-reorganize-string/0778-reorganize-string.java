import java.util.AbstractMap.SimpleEntry;

class Solution {
    public String reorganizeString(String s) {
        int[] charCounts = new int[26];
        for (char ch : s.toCharArray()) {
             charCounts[ch - 'a'] += 1;
        }

        PriorityQueue<SimpleEntry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < 26; i++) {
            if (charCounts[i] > 0) {
                pq.add(new SimpleEntry<>(Character.valueOf((char) (i + 'a')), charCounts[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            SimpleEntry<Character, Integer> first = pq.poll();
            if (sb.length() == 0 || first.getKey() != sb.charAt(sb.length() - 1)) {
                sb.append((char) first.getKey());
                first.setValue(first.getValue() - 1);
                if (first.getValue() > 0) {
                    pq.add(first);
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }

                SimpleEntry<Character, Integer> second = pq.poll();
                sb.append((char) second.getKey());
                second.setValue(second.getValue() - 1);
                if (second.getValue() > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
}