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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode last = head;
        

        for(int i=0;i<n;i++){
            last = last.next;
        }
        if(last == null){
            return head.next;
        }
        ListNode target = head;
        while(last.next != null){
            last = last.next;
            target = target.next;
        }

        target.next = target.next.next;

        return head;

    }
}
