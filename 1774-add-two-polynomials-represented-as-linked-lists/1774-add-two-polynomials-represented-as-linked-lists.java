/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode p1 = poly1;
        PolyNode p2 = poly2;
        PolyNode sum = new PolyNode();
        PolyNode curr = sum;
        while (p1 != null && p2 != null) {
            if (p1.power == p2.power) {
                if (p1.coefficient + p2.coefficient != 0) {
                    curr.next = new PolyNode(p1.coefficient + p2.coefficient, p1.power);
                    curr = curr.next;
                }
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.power > p2.power) {
                curr.next = p1;
                p1 = p1.next;
                curr = curr.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
                curr = curr.next;
            }
        }
        if (p1 == null) {
            curr.next = p2;
        } else {
            curr.next = p1;
        }
        return sum.next;
    }
}