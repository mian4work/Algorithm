import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public boolean isLocked = false, isRoot = false;
    public Node parent, left, right;

    public boolean isLocked() {
        return isLocked;
    }

    public boolean lock() {
        if(this.lockable()) {
            isLocked = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean unlock() {
        if(lockable()) {
            isLocked = false;
            return true;
        } else {
            return false;
        }
    }

    private boolean lockable() {
        boolean lockable = true;
        //ancestor
        Node ancestor = parent;
        while(!ancestor.isRoot) {
            lockable &= !ancestor.isLocked;
            ancestor = ancestor.parent;
        }

        //descendants use BFS
        Queue<Node> queue = new LinkedList<>();
        if(left != null) {
            queue.offer(left);
        }
        if(right != null) {
            queue.offer(right);
        }
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            lockable &= !node.isLocked;

            if(node.left != null) {
                queue.offer(node.left);
            }

            if(node.right != null) {
                queue.offer(node.right);
            }
        }

        return lockable;
    }

    public void addLeft(Node left) {
        left.parent = this;
        this.left = left;
    }

    public void addRight(Node right) {
        right.parent = this;
        this.right = right;
    }
}
