/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int begin1, int last1, int[] inorder, int begin2, int last2) {
        if (begin1 > last1) {
            return null;
        }

        int val = preorder[begin1];
        int index = begin2;
        for (int i = begin2; i <= last2; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        int leftTreeSize = index - begin2;
        int rightTreeSize = last2 - index;

        int preorderLeftBegin = begin1 + 1;
        int preorderLeftLast = preorderLeftBegin + leftTreeSize - 1;
        int preorderRightBegin = preorderLeftLast + 1;
        int preorderRightLast = last1;

        int inorderLeftBegin = begin2;
        int inorderLeftEnd = inorderLeftBegin + leftTreeSize - 1;
        int inorderRightBegin = index + 1;
        int inorderRightEnd = last2;

        TreeNode left = build(preorder, 
                            preorderLeftBegin, 
                            preorderLeftLast, 
                            inorder, 
                            inorderLeftBegin, 
                            inorderLeftEnd);
        TreeNode right = build(preorder,
                            preorderRightBegin,
                            preorderRightLast,
                            inorder,
                            inorderRightBegin,
                            inorderRightEnd);
        return new TreeNode(val, left, right);
    }
}
