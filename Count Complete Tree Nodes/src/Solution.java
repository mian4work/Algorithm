/*
    Given a complete binary tree, count the number of nodes.

    Note:

    Definition of a complete binary tree from Wikipedia:
    In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the
    last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

    Example:

    Input:
        1
       / \
      2   3
     / \  /
    4  5 6

    Output: 6
 */
public class Solution {
    /**
     * To solve this problem, we can simply do the recursive calls and count the nodes.
     * But it is not optimized. See the next countNodesOptimized method.
     *
     * The logic:
     *      1. if node is null return 0
     *      2. return countNodes(left) + countNodes(right) + 1 (don't forget add itself)
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    /**
     * A complete binary tree may not be 'perfect' means it is not balanced.
     *
     * For example below is not perfect
     *         1
     *        / \
     *       2   3
     *      / \  /
     *     4  5 6
     *
     * but in this tree, the following subtree is balanced:
     *
     *       2
     *      / \
     *     4  5
     *
     * So we can optimized it to check if the sub tree (either left or right) is balanced but count the left only nodes
     * and right only nodes. If the left only nodes == right only nodes, we can immediately return:
     *      Math.pow(2, level)
     *
     *      example, if level is 2: the total node is 2*2 - 1 == 3
     *
     * @param root
     * @return
     */
    public int countNodesOptimized(TreeNode root) {
        int leftHeight = 0, rightHeight = 0;
        TreeNode leftNode = root, rightNode = root;
        //quick check if the sub tree is perfect or balanced:
        while(leftNode != null) {
            ++leftHeight;
            leftNode = leftNode.left;
        }

        while(rightNode != null) {
            ++rightHeight;
            rightNode = rightNode.right;
        }

        //if left and right height are the same, it is balanced return. if root == null, then 0==0, return 0
        if(leftHeight == rightHeight) {
            return (int)Math.pow(2, leftHeight) - 1;
        }

        //if it is not a balance tree, keep going
        return countNodesOptimized(root.left) + countNodesOptimized(root.right) + 1;
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
