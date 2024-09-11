class Solution {
    public int minBitFlips(int start, int goal) {
        int XORres = start ^ goal;
        int count = 0;
        while (XORres != 0) {
            count += XORres & 1;
            XORres >>= 1;
        }
        return count;
    }
}