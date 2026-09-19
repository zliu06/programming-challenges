# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        next = None
        last = None
        first = None
        while list1 != None and list2 != None:
            if list1.val < list2.val:
                next = list1
                list1 = list1.next
            else:
                next = list2
                list2 = list2.next
            if last != None:
                last.next = next
                last = next
            else:
                last = next
                first = next
        if list1 != None:
            next = list1
            if last != None:
                last.next = next
                last = next
            else:
                last = next
                first = next

        if list2 != None:
            next = list2
            if last != None:
                last.next = next
                last = next
            else:
                last = next
                first = next

        return first
