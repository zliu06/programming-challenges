# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if node is None:
                return (0, 0)
            left_take, left_skip = dfs(node.left)
            right_take, right_skip = dfs(node.right)
            take = node.val + left_skip + right_skip
            skip = max(left_take, left_skip) + max(right_take, right_skip)
            return (take, skip)
        take, skip = dfs(root)
        return max(take, skip)