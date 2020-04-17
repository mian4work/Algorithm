public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    char[][] grid = new char[][]{{'1','1','1'}, {'0','1','0'},{'1','1','1'}};
		char[][] grid1 = new char[][]{{'1'}, {'1'}};
	    System.out.println(solution.numIslands(new char[][]{{'1'}, {'1'}}));
		System.out.println(solution.numIslands(new char[][]{{'1','1','1'}, {'0','1','0'},{'1','1','1'}}));
		System.out.println(solution.numIslands(new char[][]{{'1','1','1'}, {'1','1','1'},{'1','1','1'}}));
		System.out.println(solution.numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
		System.out.println(solution.numIslands(new char[][]{{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}}));
    }
}
