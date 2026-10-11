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
    public int maxDepth(TreeNode root) {
        DFS dfs = new DFS();
        dfs.traverse(root, 0);
        return dfs.depth;
    }

    static class DFS {
        public int depth = 0;

        void traverse(TreeNode root, int parentDepth) {
            if (root == null) return;
            depth = Math.max(depth, parentDepth+1);
            traverse(root.left, parentDepth+1);
            traverse(root.right, parentDepth+1);
        }
    }
}
