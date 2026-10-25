# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        best = None

        def dfs(node):
            nonlocal best
            if node is None:
                return 0
            left = max(0, dfs(node.left))
            right = max(0, dfs(node.right))
            if best is None or left + right + node.val > best:
                best = left + right + node.val
            return node.val + max(left, right)

        dfs(root)
        return best
