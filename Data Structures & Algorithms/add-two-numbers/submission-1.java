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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode curr = res;
        int rem = 0;

        while(l1!=null && l2!=null){
            int nodeVal = (l1.val+l2.val+rem)%10;
            rem = (l1.val+l2.val+rem)/10;

            ListNode tempNode = new ListNode(nodeVal);
            curr.next = tempNode;
            curr = curr.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int nodeVal = (l1.val+rem)%10;
            rem = (l1.val+rem)/10;

            ListNode tempNode = new ListNode(nodeVal);
            curr.next = tempNode;
            curr = curr.next;
            l1=l1.next;
        }
        while(l2!=null){
            int nodeVal = (l2.val+rem)%10;
            rem = (l2.val+rem)/10;

            ListNode tempNode = new ListNode(nodeVal);
            curr.next = tempNode;
            curr = curr.next;
            l2=l2.next;
        }
        if(rem !=0){
            ListNode tempNode = new ListNode(rem);
            curr.next = tempNode;
        }

        return res.next;
    }
}
