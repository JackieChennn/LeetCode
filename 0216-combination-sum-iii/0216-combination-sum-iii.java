class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private int[] arr = new int[]{1,2,3,4,5,6,7,8,9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(0, 0, k, n, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int count, int k, int n, List<Integer> currList) {
        if (count == k) {
            if (n == 0) {
                result.add(new ArrayList<>(currList));
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            currList.add(arr[i]);
            backtrack(i + 1, count + 1, k, n - arr[i], currList);
            currList.remove(currList.size() - 1);
        }
    }
}