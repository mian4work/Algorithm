
public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
	    System.out.println(solution.isValidSequence(root, new int[]{1,2}));

	    TreeNode root1 = new TreeNode(8);
	    TreeNode two = new TreeNode(2, new TreeNode(5), new TreeNode(4));
	    TreeNode three = new TreeNode(3, two, new TreeNode(1));
	    root1.left = three;

	    System.out.println(solution.isValidSequence(root1, new int[]{8}));
		TreeNode root2 = new TreeNode(3, new TreeNode(0, new TreeNode(2), null), null);
		System.out.println(solution.isValidSequence(root2, new int[]{3,0}));
    }
}
