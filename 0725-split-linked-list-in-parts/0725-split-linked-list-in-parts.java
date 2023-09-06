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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode itr = head;
        while (itr != null) {
            itr = itr.next;
            count++;
        }
        int eachPartCount = count / k;
        int remainder = count % k;
        ListNode[] result = new ListNode[k];
        itr = head;
        for (int i = 0; i < k; i++) {
            ListNode currHead = itr;
            result[i] = currHead;
            for (int j = 0; j < eachPartCount + (remainder > 0 ? 1 : 0) - 1; j++) {
                itr = itr.next;
            }
            ListNode temp = itr;
            if (temp != null) {
                itr = itr.next;
                temp.next = null;
            }

            remainder--;
        }
        return result;
    }
}