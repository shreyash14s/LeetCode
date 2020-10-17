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
    ListNode rethead, top;
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        rethead = head;
        top = head;
        recRotate(head, k, 0);
        return rethead;
    }
    
    int recRotate(ListNode head, int k, int cnt) {
        if (head.next == null) {
            int v = k % (cnt+1);
            if (v != 0) head.next = top;
            return v;
        }
        int v = recRotate(head.next, k, cnt+1) - 1;
        if (v == 0) {
            rethead = head.next;
            head.next = null;
        }
        return v;
    }
}
