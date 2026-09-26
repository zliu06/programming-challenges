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
    public boolean isValidBST(TreeNode root) {

        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    private boolean isValid(TreeNode root, int lowerBound, int upperBound) {

        if (root == null) {
            return true;
        }

        int val = root.val;
        if (val < lowerBound || val > upperBound ) {
            return false;
        }
        boolean isValidLeft = isValid(root.left, lowerBound, val - 1);

        boolean isValidRight = isValid(root.right, val+1, upperBound);

        return isValidLeft && isValidRight;
    }
}
