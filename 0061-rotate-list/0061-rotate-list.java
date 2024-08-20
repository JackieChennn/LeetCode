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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> lst = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            lst.add(curr);
            curr = curr.next;
        }
        int n = lst.size();
        int rotate = k % n;
        if (rotate == 0) {
            return head;
        }
        ListNode result = lst.get(n - rotate);
        ListNode newTail = lst.get(n - rotate - 1);
        newTail.next = null;
        ListNode oldTail = lst.get(n - 1);
        oldTail.next = head;
        return result;
    }
}