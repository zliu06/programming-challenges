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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<NodeWithLevel> queue = new ArrayDeque<>();
        if (root != null)
            queue.offer(new NodeWithLevel(root, 1));
        List<List<Integer>> response = new ArrayList<>();
        new BFS().traverse(queue, response);
        return response;
    }

    record NodeWithLevel(TreeNode node, int level) {}

    class BFS 
    {
        int lastLevel = 0;
        void traverse(Queue<NodeWithLevel> queue, List<List<Integer>> response) {
            while (!queue.isEmpty()) {
                NodeWithLevel e = queue.poll();
                int level = e.level;
                TreeNode node = e.node;
                if (level > lastLevel) {
                    response.add(new ArrayList<>());
                }
                response.get(response.size()-1).add(node.val);
                lastLevel = level;
                if (node.left != null)
                    queue.offer(new NodeWithLevel(node.left, level+1));
                if (node.right != null)
                    queue.offer(new NodeWithLevel(node.right, level+1));
            }
        }
    }
}
