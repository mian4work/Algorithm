import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * My first try. Use a queue to save element in same depth. Use a pipe as a separator.
     * Check the children on the way down.
     *
     * beat 100% but the logic looks ugly. Need find a better way. Should I not get into the children? 
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || (root.right == null && root.left == null)) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode pipe = new TreeNode(-1);
        boolean foundX = false, foundY = false;
        if(root.left != null) {
            queue.add(root.left);
        }
        if(root.right != null) {
            queue.add(root.right);
        }
        queue.add(pipe); //pipe as seperator

        while(queue.size() > 0) {
            TreeNode node = queue.poll();
            if(node.val != -1) {
                if(node.left != null) {
                    if(node.left.val == x) {
                        if(foundY && (node.right == null || node.right.val != y)) {
                            return true;
                        } else {
                            foundX = true;
                        }
                    }

                    if(node.left.val == y) {
                        if(foundX && (node.right == null ||node.right.val != x)) {
                            return true;
                        } else {
                            foundY = true;
                        }
                    }

                    queue.add(node.left);
                }

                if(node.right != null) {
                    if(node.right.val == x) {
                        if(foundY && (node.left == null ||node.left.val != y)) {
                            return true;
                        } else {
                            foundX = true;
                        }
                    }

                    if(node.right.val == y) {
                        if(foundX && (node.left == null ||node.left.val != x)) {
                            return true;
                        } else {
                            foundY = true;
                        }
                    }

                    queue.add(node.right);
                }
            } else {
                if(queue.size() != 0) {
                    queue.add(node);
                    foundX = false;
                    foundY = false;
                }
            }
        }

        return false;
    }
}
