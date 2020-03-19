public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

	    System.out.println(solution.sumRange(nums, 0, 2));
		System.out.println(solution.sumRange(nums, 2, 5));
		System.out.println(solution.sumRange(nums, 0, 5));

		solution = new Solution(nums);
		System.out.println(solution.sumRange(0, 2));
		System.out.println(solution.sumRange(2, 5));
		System.out.println(solution.sumRange(0, 5));
    }
}
