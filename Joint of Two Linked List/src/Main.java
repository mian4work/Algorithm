public class Main {

    public static void main(String[] args) {
        //A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10
	    Node a = new Node(3);
	    a.add(7).add(8).add(10);
	    Node b = new Node(99);
	    b.add(1).add(8).add(10);
	    Solution solution = new Solution();
	    System.out.println(solution.joint(a, b));
    }
}
