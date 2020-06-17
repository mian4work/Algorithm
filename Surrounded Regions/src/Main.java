public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    
	    char[][] board = new char[][]{
	            {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}};

	    solution.solve(board);
	    return;
    }
}
