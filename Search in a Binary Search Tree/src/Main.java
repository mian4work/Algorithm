public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
	    TreeNode root = new TreeNode(18, new TreeNode(2), new TreeNode(22, null, new TreeNode(63, null, new TreeNode(84))));

	    TreeNode node = solution.searchBST(root, 63);
	    return;
    }
}
