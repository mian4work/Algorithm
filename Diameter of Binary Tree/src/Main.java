public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

	    TreeNode root = new TreeNode(1);
	    TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
	    root.left = two;
	    root.right = three;
	    two.left = four;
	    two.right = five;

	    System.out.println(solution.diameterOfBinaryTree(root));
    }
}
