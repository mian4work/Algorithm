public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    System.out.println(solution.regex("ra.", "ray"));
        System.out.println(solution.regex("ra.", "raymond"));
        System.out.println(solution.regex(".*at", "chat"));
        System.out.println(solution.regex(".*at", "chats"));
        //System.out.println(solution.regex("", ""));
    }
}
