public class Main {

    public static void main(String[] args) {
	    //construct a tree
        Node root = new Node();
        root.isRoot = true;

        Node left1 = new Node();
        Node right1 = new Node();
        Node left2 = new Node();
        Node right2 = new Node();

        root.addLeft(left1);
        root.addRight(right1);
        left1.addLeft(left2);
        left1.addRight(right2);

        System.out.println(left1.lock());
        System.out.println(left2.lock());
        System.out.println(left1.unlock());
    }
}
