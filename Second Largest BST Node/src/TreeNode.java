public class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

    public TreeNode add(int value) {
        TreeNode node = new TreeNode(value);

        if(value < this.value) {
            left = node;
        } else {
            right = node;
        }

        return node;
    }
}
