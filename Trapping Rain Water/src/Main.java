public class Main {

    public static void main(String[] args) {
	    int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

	    Solution solution = new Solution();
	    System.out.println("Brute Force Solution: " + solution.trapBruteForce(height));
		System.out.println("Pre calculation Solution: " + solution.trapPrefixMax(height));
    }
}
