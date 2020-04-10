public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    System.out.println(solution.backspaceCompare("ab##", "c#d#"));
		System.out.println(solution.backspaceCompare("a##c", "#a#c"));
		System.out.println(solution.backspaceCompare("a#c", "b"));
		System.out.println(solution.backspaceCompare("bxj##tw", "bxo#j##tw"));
        System.out.println(solution.backspaceCompare("isfcow#", "isfco#w#"));
    }
}
