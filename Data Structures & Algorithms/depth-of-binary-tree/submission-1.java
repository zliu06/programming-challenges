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

        void traverse(TreeNode node, int parentDepth) {
            if (node == null) return;
            int nodeDepth = parentDepth+1;
            depth = Math.max(depth, nodeDepth);
            traverse(node.left, nodeDepth);
            traverse(node.right, nodeDepth);
        }
    }
}
