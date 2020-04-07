public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    System.out.println(solution.wellFormed("([])[]({})"));
        System.out.println(solution.wellFormed("([)]"));
        System.out.println(solution.wellFormed("((()"));
        System.out.println();
    }
}
