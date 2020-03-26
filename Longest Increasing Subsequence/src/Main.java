public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLIS(new int[]{1}));
        System.out.println(solution.lengthOfLIS(new int[]{1, 1, 1}));

        System.out.println(solution.lengthOfLISImprove(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLISImprove(new int[]{1}));
        System.out.println(solution.lengthOfLISImprove(new int[]{1, 1, 1}));
    }
}
