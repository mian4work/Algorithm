/*
    Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree
    is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    Example:
    Given a binary tree
              1
             / \
            2   3
           / \
          4   5
    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class Solution {

    /**
     * My solution is a mess!!!
     *
     * It is a simple depth first search.
     *
     * Search left and right, return the longest path between left and right.
     *      Note: you need to +1 because the longest need count the node itself.
     *
     * You return the longest path for next recursion at the same time, record the diameter by left+right and compare with
     * the max diameter recorded so far.
     *
     * Refer the commented code to track my thoughts.
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        dfs(root, max);
        return max[0];
    }

    int dfs(TreeNode node, int[] max) {
        if(node == null) {
            return 0;
        }

        int left = dfs(node.left, max);
        int right = dfs(node.right, max);

        max[0] = Math.max(max[0], left + right);

        return Math.max(left, right) + 1; //to include the node itself.
    }

//    public int diameterOfBinaryTree(TreeNode root) {
//        return maxDiameter(root, 0);
//    }
//
//    int maxDiameter(TreeNode node, int max) {
//        if(node == null || (node.left == null && node.right == null)) {
//            return 0;
//        }
//        Map<TreeNode, Integer> map = new HashMap<>();
//        if(node.left == null) {
//            return Math.max(max, maxLen(node.right, map) + 1);
//        } else if(node.right == null) {
//            return Math.max(max, maxLen(node.left, map) + 1);
//        } else {
//            return Math.max(max, maxLen(node.left, map) + maxLen(node.right, map) + 2);
//        }
//    }
//
//    int maxLen(TreeNode node, Map<TreeNode, Integer> map) {
//        if(node == null) {
//            return 0;
//        }
//
//        if(map.get(node) != null) {
//            return map.get(node);
//        }
//
//        int max = 0;
//        if(node.left != null && node.right != null) {
//            max = Math.max(maxLen(node.left, map) + 1, maxLen(node.right, map) + 1);
//        } else if(node.left == null) {
//            max = maxLen(node.right, map) + 1;
//        } else if(node.right == null) {
//            max = maxLen(node.left, map) + 1;
//        }
//        map.put(node, max);
//        return max;
//    }
}
