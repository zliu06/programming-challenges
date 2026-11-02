# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        rprev = None
        cur = head
        while cur is not None:
            tmp = cur.next
            cur.next = rprev
            rprev = cur
            cur = tmp
        return rprev