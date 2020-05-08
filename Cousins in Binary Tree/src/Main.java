public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(5)));
	    System.out.println(solution.isCousins(root, 5, 4));
    }
}
