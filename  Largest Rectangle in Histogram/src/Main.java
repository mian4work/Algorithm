public class Main {

    public static void main(String[] args) {
	    SolutionWrong solutionWrong = new SolutionWrong();
	    int[] arr = new int[]{2,1,5,6,2,3};

	    System.out.println(solutionWrong.largestRectangleAreaBruteForce(arr));
		System.out.println(solutionWrong.largestRectangleAreaStack(arr));
		System.out.println(solutionWrong.largestRectangleAreaStack(new int[]{1}));
    }
}
