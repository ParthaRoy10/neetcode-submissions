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

        ListNode sl = head;
        ListNode fst = head;

        while(fst != null && fst.next != null){
            sl = sl.next;
            fst = fst.next.next;
        }

        ListNode prev = null;
        ListNode curr = sl.next;
        sl.next = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode l2 = prev;
        ListNode l1 = head;
        while(l2 != null && l1 != null){
            ListNode l1n = l1.next;
            ListNode l2n = l2.next;

            l1.next = l2;
            l2.next = l1n;

            l1 = l1n;
            l2 = l2n;
        }
    }
}
