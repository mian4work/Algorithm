public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    System.out.println(solution.numDecodings("1"));
        System.out.println(solution.numDecodings("12"));
        System.out.println(solution.numDecodings("123"));
        System.out.println(solution.numDecodings("1234"));

        System.out.println(solution.numDecodingsMemo("1"));
        System.out.println(solution.numDecodingsMemo("12"));
        System.out.println(solution.numDecodingsMemo("123"));
        System.out.println(solution.numDecodingsMemo("1234"));
    }
}
