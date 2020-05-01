/*
    Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string
    is a valid sequence in such binary tree.

    We get the given string from the concatenation of an array of integers arr and the concatenation of all values
    of the nodes along a path results in a sequence in the given binary tree.



    Example 1:

    Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
    Output: true
    Explanation:
    The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
    Other valid sequences are:
    0 -> 1 -> 1 -> 0
    0 -> 0 -> 0

    Example 2:

    Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
    Output: false
    Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.

    Example 3:

    Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
    Output: false
    Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.


    Constraints:

    1 <= arr.length <= 5000
    0 <= arr[i] <= 9
    Each node's value is between [0 - 9].
 */
public class Solution {
    /**
     * The key to to check if a node is a leaf as well as the arr is in last element.
     *      1. if it is a leaf and it is at the last element, return node.val == arr[index]
     *      2. if it is not a leaf but index > len - 1, return false
     *      3. if the value node.val != arr[index], return false (prone the tree)
     *      4. if the node is null, it shouldn't hit this point but if so, return false.
     *
     * A reference from online:
     *
     * 树遍历到了叶节点（描述叶节点就是检验左右子树是否为空），数组也遍历到了最后一个元素，那么只需检验叶节点的值和数组元素值是否相等
     * 树还没有到叶节点，但是数组已经到了末尾，为false
     * 树到了叶节点，但是数组还没有到末尾，为false
     *
     * @param root
     * @param arr
     * @return
     */
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    boolean dfs(TreeNode node, int[] arr, int index) {
        if(node == null) {
            return false;
        }

        if(node.left == null && node.right == null) {
            return index == arr.length - 1 ? node.val == arr[index] : false;
        }

        if((node.left != null || node.right != null) && index > arr.length - 1) {
            return false;
        }

        if(node.val != arr[index]) {
            return false;
        }

        return dfs(node.left, arr, index + 1) || dfs(node.right, arr, index + 1);
    }
}
