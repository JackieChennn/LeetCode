class Solution {

    private List<List<Integer>> result;
    private int n;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, new ArrayList<>(), candidates, target);
        return result;
    }

    private void backtrack(int start, List<Integer> currList, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList(currList));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < n; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            currList.add(candidates[i]);
            backtrack(i + 1, currList, candidates, target - candidates[i]);
            currList.remove(currList.size() - 1);
        }
    }
}