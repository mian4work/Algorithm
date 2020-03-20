public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    System.out.println(solution.uniquePathsDP(1, 1));
        System.out.println(solution.uniquePathsDP(2, 2));
        System.out.println(solution.uniquePathsDP(3, 3));

        System.out.println(solution.uniquePathsArray(1, 1));
        System.out.println(solution.uniquePathsArray(2, 2));
        System.out.println(solution.uniquePathsArray(3, 3));
    }
}
