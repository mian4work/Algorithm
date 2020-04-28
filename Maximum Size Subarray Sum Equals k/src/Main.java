public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

        System.out.println(solution.subarraySumPrefixSum(new int[]{1,1,1}, 2));
        System.out.println(solution.subarraySumPrefixSumNoArray(new int[]{1,1,1}, 2));
        System.out.println(solution.subarraySumTwoPointer(new int[]{1,1,1}, 2));
	    System.out.println(solution.subarraySumGreedy(new int[]{1,1,1}, 2));
    }
}
