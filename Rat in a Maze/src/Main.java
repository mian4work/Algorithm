public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    int[][] board = new int[][]{{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
	    printPath(solution.ratMove(board));
    }

    static void printPath(int[][] path) {
    	if(path == null) {
			System.out.println("No path");
			return;
		}
    	for(int i = 0; i < path.length; i++) {
    		for(int j = 0; j < path.length; j++) {
    			System.out.print("[" + path[i][j] + "]");
			}
    		System.out.println();
		}
	}
}
