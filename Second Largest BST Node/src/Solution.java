/*
    This problem was asked by Dropbox.

    Given the root to a binary search tree, find the second largest node in the tree.
 */
public class Solution {

    public TreeNode secondLargest(TreeNode root) {
        if(root == null) {
            return null;
        }

        return helper(root, root);
    }

    public TreeNode helper(TreeNode node, TreeNode parent) {
        if(node.left == null && node.right == null) {
            return parent;
        } else if(node.right == null && node.left != null) {
            return node.left;
        }

        return helper(node.right, node);
    }
}
