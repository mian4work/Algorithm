public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
	    solution.floodFill(image, 1, 1, 2);
	    return;
    }
}
