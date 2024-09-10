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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode currNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            ListNode newNode = new ListNode(gcd(currNode.val, nextNode.val), nextNode);
            currNode.next = newNode;
            currNode = nextNode;
            nextNode = currNode.next;
        }
        return head;
    }
    
    private int gcd(int a, int b) {
        if (b==0) {
            return a;
        }
        return gcd(b, a % b);
}
}