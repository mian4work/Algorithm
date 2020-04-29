public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
	    //System.out.println(solution.maxPathSum(root1));
	    TreeNode root2 = new TreeNode(2);
	    root2.left = new TreeNode(-1);
	    //System.out.println(solution.maxPathSum(root2));
		TreeNode root3 = new TreeNode(-3);
		System.out.println(solution.maxPathSum(root3));
    }
}
