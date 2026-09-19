# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        # my method is to use a list to keep index to node mapping
        # then after one single scan, I get the total length of the list, and can find which element to delete
        # use my map, I can identify the previous node and the next node of the node to delete

        ptrs = []

        curr = head
        while curr:
            ptrs.append(curr)
            curr = curr.next
        
        length = len(ptrs)
        t = length - n

        if t > 0:
            ptrs[t - 1].next = ptrs[t].next
            return head
        else:
            return head.next
