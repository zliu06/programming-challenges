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
        Builder builder = new Builder();
        builder.init(inorder);
        return builder.build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    class Builder {
        HashMap<Integer, Integer> valToIndex = new HashMap<>();

        void init(int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                valToIndex.put(inorder[i], i);
            }
        }

        TreeNode build(
            int[] preorder, 
            int pFirst, 
            int pLast, 
            int[] inorder, 
            int iFirst, 
            int iLast)    
        {
            if (pFirst > pLast) return null;
            int val = preorder[pFirst];
            int index = valToIndex.get(val);
            int leftLength = index-iFirst;
            TreeNode node = new TreeNode(val);
            TreeNode left = build(preorder,pFirst+1,pFirst+leftLength,inorder,iFirst,index-1);
            TreeNode right = build(preorder,pFirst+leftLength+1,pLast,inorder,index+1,iLast);
            node.left = left;
            node.right = right;
            return node;
        }
    }
}
