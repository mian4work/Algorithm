import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
    You need to find the largest value in each row of a binary tree.

    Example:
    Input:

              1
             / \
            3   2
           / \   \
          5   3   9

    Output: [1, 3, 9]
 */
class Solution {
    /**
     * By using queue and a pipe (sudo node), we can do it level by level.
     *
     * The problem in this case is how to define a pipe since the val is a int, not a Integer.
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode pipe = new TreeNode(Integer.MAX_VALUE);
        queue.add(root);
        queue.add(pipe);

        int rowMax = Integer.MIN_VALUE;
        while(queue.size() > 0) {
            TreeNode node = queue.poll();
            if(isPipe(node)) {
                list.add(rowMax);
                rowMax = Integer.MIN_VALUE;
                if(queue.size() > 0) {
                    queue.add(node);
                }
            } else {
                rowMax = Math.max(rowMax, node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return list;
    }

    boolean isPipe(TreeNode node) {
        return node.val == Integer.MAX_VALUE;
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
