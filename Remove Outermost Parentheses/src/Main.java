public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    System.out.println(solution.removeOuterParentheses("(()())(())"));
        System.out.println(solution.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(solution.removeOuterParentheses("()()()"));
    }
}
