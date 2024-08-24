class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        int i = len % 2 == 0 ? len / 2 - 1 : len / 2;
        long leftHalf = Long.parseLong(n.substring(0, i + 1));
        List<Long> possibilities = new ArrayList<>();
        possibilities.add(halfToPalindrome(leftHalf, len % 2 == 0));
        possibilities.add(halfToPalindrome(leftHalf + 1, len % 2 == 0));
        possibilities.add(halfToPalindrome(leftHalf - 1, len % 2 == 0));
        possibilities.add((long) Math.pow(10, len - 1) - 1);
        possibilities.add((long) Math.pow(10, len) + 1);
        long diff = Long.MAX_VALUE;
        long res = 0;
        long number = Long.parseLong(n);
        for (long candidate : possibilities) {
            if (candidate == number) {
                continue;
            }
            if (Math.abs(candidate - number) < diff) {
                diff = Math.abs(candidate - number);
                res = candidate;
            } else if (Math.abs(candidate - number) == diff) {
                res = Math.min(res, candidate);
            }
        }
        return String.valueOf(res);
    }

    private long halfToPalindrome(long left, boolean even) {
        long res = left;
        if (!even) {
            left /= 10;
        }
        while (left > 0) {
            res = res * 10 + (left % 10);
            left /= 10;
        }
        return res;
    }
}