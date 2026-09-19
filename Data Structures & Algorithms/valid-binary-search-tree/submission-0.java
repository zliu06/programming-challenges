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
        ValidationResult result = validate(root);
        return result.isValid;
    }

    ValidationResult validate(TreeNode root) {
        if (root == null) {
            return new ValidationResult(true, null, null);
        }

        ValidationResult left = validate(root.left);
        ValidationResult right = validate(root.right);
        boolean isValid = left.isValid && right.isValid && (left.maxValue == null || left.maxValue < root.val) && (right.minValue == null || right.minValue > root.val);
        Integer minValue = isValid ? (left.minValue == null ? root.val : left.minValue): null;
        Integer maxValue = isValid ? (right.maxValue == null ? root.val : right.maxValue): null;
        return new ValidationResult(isValid, minValue, maxValue); 
    }

    static class ValidationResult {
        boolean isValid;
        Integer maxValue;
        Integer minValue;

        ValidationResult(boolean isValid, Integer minValue, Integer maxValue) {
            this.isValid = isValid;
            this.minValue = minValue;
            this.maxValue = maxValue; 
        }
    }

}
