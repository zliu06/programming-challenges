# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        numToIndex = {}
        for i, num in enumerate(inorder):
            numToIndex[num] = i

        preIndex = 0

        def build(left, right):
            nonlocal preIndex

            if left > right:
                return None

            root = preorder[preIndex]
            preIndex += 1

            split = numToIndex[root]
            node = TreeNode(root)
            node.left = build(left, split - 1)
            node.right = build(split + 1, right)
            return node

        return build(0, len(preorder) - 1)
