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
        if(head ==null || head.next == null){
            return;
        }

        ListNode mid = head;
        ListNode end = head;

        while ( end.next != null && end.next.next != null){
            mid = mid.next;
            end = end.next.next;
        }

        ListNode second = mid.next;
        mid.next = null;

        ListNode prev = null;
        while(second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        second = prev;
        while (second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second ; 
            second.next =temp1;

            first=temp1;
            second =temp2;
        } 
    }
}
