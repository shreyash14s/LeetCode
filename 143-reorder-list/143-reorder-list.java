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
    public void reorderList(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        
        cur = head;
        ListNode next = null;
        int n = stack.size() / 2;
        while (n > 0) {
            ListNode last = stack.pop();
            n--;
            if (last == cur) break;
            next = cur.next;
            last.next = next;
            cur.next = last;
            
            cur = next;
        }
        cur.next = null;
    }
}
