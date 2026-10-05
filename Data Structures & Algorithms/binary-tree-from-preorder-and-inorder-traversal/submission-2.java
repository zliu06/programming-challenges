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
        
        if (preorder.length < 1) {
            return null;
        }

        Map<Integer, Integer> valToIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
         
        return buildTreeRec(valToIndex, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);    
    }

    private TreeNode buildTreeRec(
        Map<Integer, Integer> valToIndex, 
        int[] preorder, 
        int first, 
        int last, 
        int[] inorder, 
        int first2, 
        int last2
    ) {
        int size = last - first + 1;
        if (size < 1) {
            return null;
        }
        int val = preorder[first];
        int index = valToIndex.get(val);
        int leftTreeSize = index - first2;

        TreeNode left = buildTreeRec(valToIndex, preorder, first+1, first+leftTreeSize, inorder, first2, index - 1);
        TreeNode right = buildTreeRec(valToIndex, preorder, first+leftTreeSize+1, last, inorder, index+1, last2);
        return new TreeNode(val, left, right);
    }
}
