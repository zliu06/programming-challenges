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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> labels = new ArrayList<>();
        serialize(root, labels);
        return String.join(",", labels);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> labels = Arrays.asList(data.split(","));

        if (labels.isEmpty()) {
            return null;
        }

        State end = dfs(labels, 0);
        return end.node;

    }

    private record State(TreeNode node, int next) {}

    private State dfs(List<String> labels, int begin) {
        if ("N".equals(labels.get(begin))) {
            return new State(null, begin+1);
        } else {
            int val = Integer.parseInt(labels.get(begin));
            State left = dfs(labels, begin+1);
            State right = dfs(labels, left.next);
            return new State(new TreeNode(val, left.node(), right.node()), right.next());
        }
    }

    private void serialize(TreeNode node, List<String> labels) {
        if (node == null) {
            labels.add("N");
        } else {
            labels.add(String.valueOf(node.val));
            serialize(node.left, labels);
            serialize(node.right, labels);
        }
    }
}
