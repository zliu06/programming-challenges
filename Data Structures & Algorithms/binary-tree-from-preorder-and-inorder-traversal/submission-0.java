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
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }

        int root = preorder[0];
        int mid = indexOf(inorder, root);
        int[] left_preorder = sublist(preorder, 1, mid);
        int[] right_preorder = sublist(preorder, mid+1);
        int[] left_inorder = sublist(inorder, 0, mid);
        int[] right_inorder = sublist(inorder, mid+1);
        TreeNode left = buildTree(left_preorder, left_inorder);
        TreeNode right = buildTree(right_preorder, right_inorder);
        return new TreeNode(root, left, right);
    }

    int indexOf(int[] array, int val) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                return i;
            }
        }
        throw new RuntimeException("indexOf failure, number " + val + " not found!");
    }

    int[] sublist(int[] array, int begin, int length) {
        int [] result = new int[length];
        for (int i = begin, j = 0; j < length; i++, j++) {
            result[j] = array[i];
        }
        return result;
    }

    int[] sublist(int[] array, int begin) {
        return sublist(array, begin, array.length - begin);
    }


}
