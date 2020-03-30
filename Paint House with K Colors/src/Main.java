public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] costs = new int[][]{{17,2,17}, {16, 16, 5}, {14,3,19}};
        System.out.println(solution.minCostBruteForce(costs));
        System.out.println(solution.minCostDP(costs));
    }
}
