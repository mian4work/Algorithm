public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    printArray(solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1));
        printArray(solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2));
        printArray(solution.kClosest(new int[][]{}, 2));
    }

    static void printArray(int[][] arr) {
        for(int[] point : arr) {
            System.out.print("[" + point[0] + ", " + point[1] + "]");
        }
        System.out.println();
    }
}
