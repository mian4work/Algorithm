public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    Recap recap = new Recap();

	    //int[] input = new int[]{4,1,1,4,2,1};
		int[] input = new int[]{1,1,1,1,1,1};

		System.out.println(solution.largestSumNonAdjacentNumbers(input));
		System.out.println(recap.largestSumNonAdjacentNumbers(input));
    }
}
