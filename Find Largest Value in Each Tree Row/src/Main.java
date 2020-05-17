public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    solution.largestValues(new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9))));
		solution.largestValues(new TreeNode());
	    return;
    }
}
