import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Note:
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    Example 1:

    Input: root = [3,1,4,null,2], k = 1
       3
      / \
     1   4
      \
       2
    Output: 1

    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
    Output: 3
    Follow up:
    What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
    How would you optimize the kthSmallest routine?
 */
public class Solution {
//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> list = new ArrayList<>();
//
//    }

    void dfs(TreeNode node, List<Integer> list, int k) {

    }

    /**
     * My first try, passed but not very efficient. I should think of BST instead of Binary Tree.
     *
     * The solution is simple:
     *      1. create a max priority queue (means convert the original tree to a heap)
     *      2. keep the size of the queue to k (in that case, the max element is the kth smallest element)
     *      3. transverse the tree to add all element
     *      4. when ever the size of queue > k, pop the top element.
     *
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallestFirstTry(TreeNode root, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        helper(root, queue, k);
        return queue.peek();
    }

    void helper(TreeNode node, PriorityQueue<Integer> queue, int k) {
        if(node == null) {
            return;
        }

        queue.add(node.val);
        if(queue.size() > k) {
            queue.poll();
        }

        helper(node.left, queue, k);
        helper(node.right, queue, k);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
