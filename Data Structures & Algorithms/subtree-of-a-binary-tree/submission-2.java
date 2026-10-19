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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    boolean dfs(TreeNode node, TreeNode subRoot) {
        if (node == null) return false;
        if (compare(node, subRoot)) return true;
        if (dfs(node.left, subRoot)) return true;
        if (dfs(node.right, subRoot)) return true;
        return true;
    }

    boolean compare(TreeNode node, TreeNode expected) {
        if (node == null && expected == null) return true;
        if (node == null || expected == null) return false;
        if (node.val != expected.val) return false;
        return compare(node.left, expected.left)
            && compare(node.right, expected.right);
    }
}
