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

    record ParseResult(TreeNode node, int next) {}

    void ser(TreeNode node, List<String> result) {
        if (node == null) {
            result.add("N");
        }
        else {
            result.add(String.valueOf(node.val));
            ser(node.left, result);
            ser(node.right, result);
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        ser(root, result);
        return String.join(",", result);
    }

    ParseResult de(String[] parts, int first) {
        if ("N".equals(parts[first])) {
            return new ParseResult(null, first+1);
        } else {
            int val = Integer.parseInt(parts[first]);
            TreeNode ret = new TreeNode(val);
            ParseResult leftResult = de(parts, first+1);
            ParseResult rightResult = de(parts, leftResult.next);
            ret.left = leftResult.node;
            ret.right = rightResult.node;
            return new ParseResult(ret, rightResult.next);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(",");
        return de(parts, 0).node;
    }

}
