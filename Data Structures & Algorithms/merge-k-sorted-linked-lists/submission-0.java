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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){return null;}
        int period = 1;
        while(period < lists.length){
            for(int i=0; i+period < lists.length ; i += period*2){
                lists[i] = mergeTwoList(lists[i],lists[i+period]); 
            }
            period = period*2;
        }
        return lists[0];
    }
    private ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1 == null){return l2;}
        if(l2 == null){return l1;}

        ListNode ans = new ListNode(0);
        ListNode dummyNode = ans;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummyNode.next = l1;
                l1 = l1.next;
            }else{
                dummyNode.next = l2;
                l2 = l2.next;
            }
            dummyNode = dummyNode.next;
        }
        if(l1!=null){
            dummyNode.next = l1;
        }
        if(l2 != null){
            dummyNode.next = l2;
        }
        return ans.next;
    }
}
