# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # identify boundary between first half and second half
        # reverse second half
        # merge first and reversed second half

        fast = slow = head
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next

        mid = slow

        # reverse 2nd half
        head2 = None
        curr = mid.next
        while curr:
            tmp = curr.next
            curr.next = head2
            head2 = curr
            curr = tmp

        mid.next = None
        print (mid.val)

        # merge head and head2
        curr = head
        curr2 = head2
        # do i need a tail 
        while curr and curr2:
            tmp = curr.next
            tmp2 = curr2.next
            curr.next = curr2
            curr2.next = tmp
            curr = tmp
            curr2 = tmp2

