class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(Arrays.stream(nums).boxed().collect(Collectors.toList()), k);
    }

    // select the k-th largest number from the list
    private int quickSelect(List<Integer> nums, int k) {
        int pivotIndex = new Random().nextInt(nums.size());
        int pivot = nums.get(pivotIndex);
        List<Integer> large = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : nums) {
            if (num > pivot) {
                large.add(num);
            } else if (num < pivot) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }
        if (large.size() >= k) {
            return quickSelect(large, k);
        } else if (large.size() + equal.size() < k) {
            return quickSelect(small, k - large.size() - equal.size());
        } else {
            return pivot;
        }
    }
}