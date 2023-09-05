/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node itr = head;
        while (itr != null) {
            Node itrNext = itr.next;
            itr.next = new Node(itr.val);
            itr.next.next = itrNext;
            itr = itrNext;
        }
        itr = head;
        while (itr != null) {
            if (itr.random != null) {
                itr.next.random = itr.random.next;
            }
            itr = itr.next.next;
        }
        Node newHead = head.next;
        itr = head;
        Node copy = newHead;
        while (copy.next != null) {
            itr.next = itr.next.next;
            itr = itr.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        itr.next = itr.next.next;
        return newHead;
    }
}