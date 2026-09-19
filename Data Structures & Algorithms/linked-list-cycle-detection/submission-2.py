# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        fast, slow = head, head
        while True:
            if fast is None:
                return False
            if fast.next is None:
                return False
            elif fast.next.next is None:
                return False

            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                return True