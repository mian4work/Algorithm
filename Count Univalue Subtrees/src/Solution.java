/*
    A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.

    Given the root to a binary tree, count the number of unival subtrees.

    For example, the following tree has 5 unival subtrees:

       0
      / \
     1   0
        / \
       1   0
      / \
     1   1
 */
public class Solution {

    public int countUniValTree(Node root) {
        return count(root);
    }

    /**
     * The key point here is: Don't traverse to the null node. Stop at leave node (left == null && right == null) because
     * the leave node is counted as unival node.
     *
     * Then recursively add left count and right count.
     *
     * @param node
     * @return
     */
    private int count(Node node) {
        if(node.left == null && node.right == null) {
            return 1;
        }

        if(node.left != null && node.right != null && node.left.value == node.right.value) {
            return count(node.left) + count(node.right) + 1;
        } else {
            return count(node.left) + count(node.right);
        }
    }
}
