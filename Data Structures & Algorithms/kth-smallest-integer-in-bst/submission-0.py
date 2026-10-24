# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        cnt = 0

        def dfs(node):
            nonlocal cnt
            if node == None:
                return None

            res = dfs(node.left)
            if res != None:
                return res

            cnt += 1
            if cnt == k:
                return node.val
            res = dfs(node.right)
            if res != None:
                return res

        return dfs(root)
