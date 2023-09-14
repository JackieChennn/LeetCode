class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LinkedList<String>> hm = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            LinkedList<String> destList = hm.getOrDefault(origin, new LinkedList<>());
            destList.add(dest);
            hm.put(origin, destList);
        }
        hm.forEach((key, value) -> Collections.sort(value));
        dfs("JFK", result, hm);
        return result;
    }

    private void dfs(String origin, LinkedList<String> result, Map<String, LinkedList<String>> hm) {
        if (hm.containsKey(origin)) {
            LinkedList<String> destList = hm.get(origin);
            while (!destList.isEmpty()) {
                String dest = destList.pollFirst();
                dfs(dest, result, hm);
            }
        }
        result.offerFirst(origin);
    }
}