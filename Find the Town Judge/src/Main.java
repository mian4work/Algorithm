public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    System.out.println(solution.findJudge(2, new int[][]{{2,1}}));
        System.out.println(solution.findJudge(3, new int[][]{{1,3},{2,3}}));
        System.out.println(solution.findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println(solution.findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
}
