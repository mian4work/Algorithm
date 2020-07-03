import java.util.*;

/*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
    level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
 */
public class Solution {
    /**
     * This is a good one to refresh the bfs.
     *
     * bfs uses queue to save nodes.
     *      while queue is not empty, record its size first.
     *      loop to the size to poll node one by one and add them into a list
     *      at the same time, add node's left and right
     *      once loop is done, it will check the size again, and do another round (level) of loop.
     *
     * Use a stack to reverse the order of list.
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<List<Integer>> stack = new Stack<>(); //stack is to reverse the result
        Queue<TreeNode> queue = new LinkedList<>(); //queue is to do the bfs
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

            stack.push(list);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
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
