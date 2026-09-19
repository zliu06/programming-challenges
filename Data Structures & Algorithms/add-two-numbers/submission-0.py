# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        index = 0
        carry_on = 0

        l1_iter = l1
        l2_iter = l2

        dummy = ListNode()
        tail = dummy
        while l1_iter and l2_iter:
            res = l1_iter.val + l2_iter.val + carry_on
            val = res % 10
            carry_on = res // 10
            tail.next = ListNode(val)
            tail = tail.next

            l1_iter = l1_iter.next
            l2_iter = l2_iter.next

        remaining = l1_iter if l1_iter else l2_iter

        while remaining:
            res = remaining.val + carry_on
            val = res % 10
            carry_on = res // 10
            tail.next = ListNode(val)
            tail = tail.next

            remaining = remaining.next

        if carry_on > 0:
            tail.next = ListNode(carry_on)
            tail = tail.next

        return dummy.next