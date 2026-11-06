# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        groupPrev = dummy
        while groupPrev is not None:
            kth = self.getKth(groupPrev, k)
            if kth is None:
                break
            groupNext = kth.next

            prev, curr = groupNext, groupPrev.next
            while curr and curr != groupNext:
                tmp = curr.next
                curr.next = prev
                prev = curr
                curr = tmp
            
            tmp = groupPrev.next
            groupPrev.next = kth
            groupPrev = tmp
        return dummy.next

    def getKth(self, dummy, k):
        node = dummy
        for i in range(k):
            node = node.next
            if node is None:
                break
        return node