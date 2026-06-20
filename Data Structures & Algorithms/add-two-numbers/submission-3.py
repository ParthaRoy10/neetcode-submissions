# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        rem = 0
        res= ListNode(0)
        curr = res

        while rem or l1 or l2 :
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0

            sum = x+y+rem

            curr.next = ListNode(sum%10)
            curr=curr.next
            rem = sum//10

            if l1:
                l1=l1.next
            if l2:
                l2=l2.next
        return res.next;