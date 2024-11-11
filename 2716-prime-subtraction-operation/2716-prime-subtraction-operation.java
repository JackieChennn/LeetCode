class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max = -1;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // sieve[i] = 1 means i is prime number, = 0 means i is not prime number
        int[] sieve = new int[max + 1];
        Arrays.fill(sieve, 1);
        sieve[1] = 0;
        for (int i = 2; i <= Math.sqrt(max + 1); ++i) {
            if (sieve[i] == 1) {
                for (int j = i * i; j <= max; j += i) {
                    sieve[j] = 0;
                }
            }
        }
        int curr = 1;
        int i = 0;
        while (i < nums.length) {
            int diff = nums[i] - curr;
            if (diff < 0) {
                return false;
            }
            if (sieve[diff] == 1) {
                ++i;
                ++curr;
            } else {
                ++curr;
            }
        }
        return true;
    }
}