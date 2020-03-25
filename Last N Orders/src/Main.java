public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    solution.record(1);
        solution.record(2);
        solution.record(3);
        solution.record(4);
        solution.record(5);

        System.out.println(solution.getLast(5));
        System.out.println(solution.getLast(4));
        System.out.println(solution.getLast(3));
        System.out.println(solution.getLast(2));
        System.out.println(solution.getLast(1));

    }
}
