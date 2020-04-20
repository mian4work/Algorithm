/**
    Return the root node of a binary search tree that matches the given preorder traversal.

    (Recall that a binary search tree is a binary tree where for every node, any descendant of node.
    left has a value < node.val, and any descendant of node.right has a value > node.val.
    Also recall that a preorder traversal displays the value of the node first, then traverses node.left,
    then traverses node.right.)

    Example 1:

    Input: [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]

    <img src="https://assets.leetcode.com/uploads/2019/03/06/1266.png"/>

     Note:
     1 <= preorder.length <= 100
     The values of preorder are distinct.
 */
public class Solution {
    /**
     * A simple one. Done in one try.
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length < 1) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 1; i<preorder.length; i++) {
            addNode(root, preorder[i]);
        }

        return root;
    }

    void addNode(TreeNode node, int value) {
        if(node == null) {
            return;
        }

        TreeNode n = new TreeNode(value);

        if(value < node.val) {
            if(node.left == null) {
                node.left = n;
            } else {
                addNode(node.left, value);
            }
        } else {
            if(node.right == null) {
                node.right = n;
            } else {
                addNode(node.right, value);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}
