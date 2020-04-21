public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    BinaryMatrix matrix = new BinaryMatrix(new int[][]{{0, 0}, {0, 0}, {0, 1}});
	    System.out.println(solution.leftMostColumnWithOne(matrix));
    }
}
