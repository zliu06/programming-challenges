"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""


class Solution:
    def connect(self, root: "Optional[Node]") -> "Optional[Node]":
        if root is None:
            return None
        q = collections.deque()
        q.append(root)
        while len(q) > 0:
            l = len(q)
            i = 0
            while i < l:
                node = q.popleft()
                if i == l - 1:
                    pass
                else:
                    node.next = q[0]
                if node.left is not None:
                    q.append(node.left)
                if node.right is not None:
                    q.append(node.right)
                i += 1
        return root
            
