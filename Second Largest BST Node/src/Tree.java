public class Tree {
    TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void add(int value) {
        TreeNode node = new TreeNode(value);
        addNode(root, node);
    }

    void addNode(TreeNode node, TreeNode n) {
        if(node == null) {
            return;
        }

        if(n.value > node.value) {
            if(node.right == null) {
                node.right = n;
            } else {
                addNode(node.right, n);
            }
        } else {
            if(node.left == null) {
                node.left = n;
            } else {
                addNode(node.left, n);
            }
        }
    }
}
