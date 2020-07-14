public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};

	    int min = solution.findCheapestPrice(3, flights, 0, 2, 0);
	    System.out.println(min);
    }
}
