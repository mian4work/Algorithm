public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

	    char[][] m = new char[][]{{'1'}};

        //System.out.println(solution.maximalSquare(matrix));
        System.out.println(solution.maximalSquare(m));
    }
}
