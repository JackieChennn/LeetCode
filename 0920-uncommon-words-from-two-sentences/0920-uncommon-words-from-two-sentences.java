class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> hm1 = new HashMap<>();
        Map<String, Integer> hm2 = new HashMap<>();
        List<String> words1 = Arrays.asList(s1.split(" "));
        List<String> words2 = Arrays.asList(s2.split(" "));
        for (String word : words1) {
            hm1.put(word, hm1.getOrDefault(word, 0) + 1);
        }
        for (String word : words2) {
            hm2.put(word, hm2.getOrDefault(word, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String word : words1) {
            if (hm1.get(word) == 1 && !words2.contains(word)) {
                res.add(word);
            }
        }
        for (String word : words2) {
            if (hm2.get(word) == 1 && !words1.contains(word)) {
                res.add(word);
            }
        }
        String[] resArray = res.toArray(new String[res.size()]);
        return resArray;
    }
}