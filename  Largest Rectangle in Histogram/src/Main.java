public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    int[] arr = new int[]{2,1,5,6,2,3};

	    System.out.println(solution.largestRectangleAreaBruteForce(arr));
		System.out.println(solution.largestRectangleAreaStack(arr));
		System.out.println(solution.largestRectangleAreaStack(new int[]{1}));
    }
}
