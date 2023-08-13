class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // 2 pass Boyer-Moore Voting Algorithm
        // 1st pass
        int count1 = 0;
        int count2 = 0;
        Integer candidate1 = null;
        Integer candidate2 = null;
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // 2nd pass
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            }
            if (candidate2 != null && candidate2 == num) {
                count2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) {
            result.add(candidate1);
        }
        if (count2 > n / 3) {
            result.add(candidate2);
        }
        return result;
    }
}