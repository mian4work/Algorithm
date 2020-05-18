/*
    Find the sum of all left leaves in a given binary tree.

    Example:
    
        3
       / \
      9  20
        /  \
       15   7

    There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int[] sum = new int[1];
        sum(root, sum);
        return sum[0];
    }

    void sum(TreeNode node, int[] sum) {
        if(isLeaf(node)) {
            return;
        }

        if(node.left != null) {
            if(isLeaf(node.left)) {
                sum[0]++;
            } else {
                sum(node.left, sum);
            }
        }

        if(node.right != null) {
            sum(node.right, sum);
        }
    }

    boolean isLeaf(TreeNode node) {
        if(node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}