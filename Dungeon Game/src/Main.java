public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    int[][] dungeon = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};

	    System.out.println(solution.calculateMinimumHP(dungeon));
    }
}
