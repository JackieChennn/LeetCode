/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;
        int x = 0;
        int y = 0;
        int[][] res = new int[m][n];
        for (int[] row: res) {
            Arrays.fill(row, -1);
        }
        while (head != null) {
            res[x][y] = head.val;
            head = head.next;
            int nextX = x + dirs[dirIndex][0];
            int nextY = y + dirs[dirIndex][1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && res[nextX][nextY] == -1) {
                x = nextX;
                y = nextY;
            } else {
                dirIndex = (dirIndex + 1) % 4;
                x = x + dirs[dirIndex][0];
                y = y + dirs[dirIndex][1];
            }
        }
        return res;
    }
}