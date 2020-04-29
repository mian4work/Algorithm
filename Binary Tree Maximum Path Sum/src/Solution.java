/*
    Given a non-empty binary tree, find the maximum path sum.

    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
    along the parent-child connections. The path must contain at least one node and does not need to
    go through the root.

    Example 1:

    Input: [1,2,3]

          '1'
          / \
        '2' '3'

    Output: 6

    Example 2:

    Input: [-10,9,20,null,null,15,7]

       -10
       / \
      9 '20'
        /  \
      '15' '7'

    Output: 42
 */
public class Solution {
    /**
     * This problem is similar with "Diameter of Binary Tree".
     *
     * When design recursion, the return is max(left, right) + val because for parent node to calculate the sum, we
     * need to get max of left side and max of right.
     *
     * A trick is important here: when node is null, return 0. But sometime the parent is negative.
     * In this case, we set all negative children (left/right) to 0 by max(0, left/right) so when they add up, they
     * won't impact the sum. Example: [-1,-2,-3]
     *      at node -2, the max of left child and max of right child are all null which is 0 and sum is -2 + 0 + 0 = -2
     *      at node -3, the max of left child and max of right child are all null which is 0 and sum is -2 + 0 + 0 = -3
     *      at root -1, the max of left child is -2, max of right child is -3 and both set to 0 so the sum is -1
     *      so, the return is max(-2, -3, -1) == -1
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfs(root, max);
        return max[0];
    }

    int dfs(TreeNode n, int[] max) {
        if(n == null) {
            return 0;
        }

        //the key: if left or right is negative, return 0 so it will not impact the result of parent sum:left + right + val.
        int left = Math.max(0, dfs(n.left, max));
        int right = Math.max(0, dfs(n.right, max));

        //max(max, val+left+right) since if left/right is negative, they are set to 0
        max[0] = Math.max(max[0], left + right + n.val);

        //return the max(left, right)+val because we need to calculate the max PATH!!
        return Math.max(left, right) + n.val;
    }
}
