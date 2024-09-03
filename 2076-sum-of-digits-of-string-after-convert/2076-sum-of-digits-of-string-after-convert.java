class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(String.valueOf(ch - 'a' + 1));
        }
        for (int i = 0; i < k; ++i) {
            sb = transform(sb);
        }
        return Integer.valueOf(sb.toString());
    }

    private StringBuilder transform(StringBuilder sb) {
        StringBuilder res = new StringBuilder();
        int sum = 0;
        for (char ch: sb.toString().toCharArray()) {
            sum += ch - '0';
        }
        res.append(String.valueOf(sum));
        return res;
    }
}