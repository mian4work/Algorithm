public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

	    TreeNode root = new TreeNode(8);
        Tree tree = new Tree(root);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(13);

        System.out.println(solution.secondLargest(root).value);
    }
}
