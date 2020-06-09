import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    Given a binary tree, return the inorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
       1
        \
         2
        /
       3

    Output: [1,3,2]
    Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution {
    /**
     * Use loop to solve the same problem. Notice while loop's condition, even if node == null, it will be popped from
     * stack. So no need to check if node.right == null.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        stack.push(node);
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node.left);
            }

            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }

        return list;
    }

    /**
     * Use recursive is simple
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    void traversal(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }

        traversal(node.left, list);
        list.add(node.val);
        traversal(node.right, list);
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
