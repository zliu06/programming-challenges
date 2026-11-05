# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        max_sum = float("-inf")
        def dfs(node) -> int:
            nonlocal max_sum
            if node is None:
                return 0
            
            left = dfs(node.left)
            right = dfs(node.right)
            if max(left, 0) + max(right, 0) + node.val > max_sum:
                max_sum = max(left, 0) + max(right, 0) + node.val
            return node.val + max(left, right, 0)
        dfs(root)
        return max_sum