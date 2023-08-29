class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int openPenalty = 0;
        int closePenalty = 0;
        for (char ch : customers.toCharArray()) {
            if (ch == 'Y') {
                closePenalty++;
            }
        }
        int minPenalty = closePenalty;
        int closeHour = 0;
        for (int i = 1; i <= n; i++) {
            char curr = customers.charAt(i - 1);
            if (curr == 'Y') {
                closePenalty--;
            } else {
                openPenalty++;
            }
            if (openPenalty + closePenalty < minPenalty) {
                minPenalty = openPenalty + closePenalty;
                closeHour = i;
            }
        }
        if (openPenalty < minPenalty) {
            minPenalty = openPenalty;
            closeHour = n;
        }
        return closeHour;
    }
}