public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
	    int[] arr1 = new int[]{1, -3, 2, 1, -1};
	    System.out.println(solution.maxSubArray(arr));
		System.out.println(solution.maxSubArray(arr1));
    }
}
