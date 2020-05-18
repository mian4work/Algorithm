import java.util.ArrayList;
import java.util.List;

/*
    Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.

    image: https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png

    For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

    Two binary trees are considered leaf-similar if their leaf value sequence is the same.

    Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

    Constraints:

    Both of the given trees will have between 1 and 200 nodes.
    Both of the given trees will have values between 0 and 200
 */
public class Solution {
    /**
     * Nothing fancy. A easy question.
     * 
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return false;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        helper(root1, list1);
        helper(root2, list2);

        if(list1.size() != list2.size()) {
            return false;
        }

        int index = 0;
        while(index < list1.size()) {
            if(list1.get(index) != list2.get(index)) {
                return false;
            }
            index++;
        }

        return true;
    }

    void helper(TreeNode node, List<Integer> list) {
        if(node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }

        if(node.left != null) {
            helper(node.left, list);
        }

        if(node.right != null) {
            helper(node.right, list);
        }
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
