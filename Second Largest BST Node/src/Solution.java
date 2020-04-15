/*
    This problem was asked by Dropbox.

    Given the root to a binary search tree, find the second largest node in the tree.
 */
public class Solution {

    /**
     * Nothing fancy. Keep searching right node until its right child is null.
     *
     * The trick is to remember the parent node. If both left and right children is null, return parent.
     * If right is null but left exists, return left because left is always smaller than parent.
     *
     * @param root
     * @return
     */
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
