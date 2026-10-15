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

    static class DFS {
        List<String> values = new ArrayList<>();

        void traverse(TreeNode node) {
            if (node == null) {
                values.add("N");
            } else {
                values.add(String.valueOf(node.val));
                traverse(node.left);
                traverse(node.right);
            }
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        DFS dfs = new DFS();
        dfs.traverse(root);
        return String.join(",", dfs.values);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        Deserializer parser = new Deserializer();
        TreeNode root = parser.parse(parts);
        return root;
    }

    class Deserializer
    {
        int next = 0;

        TreeNode parse(String[] parts) {
            String token = parts[next];
            if ("N".equals(token)) {
                next++;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(token));
            next++;
            node.left = parse(parts);
            node.right = parse(parts);
            return node;
        }
    } 

}
