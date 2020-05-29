public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    printArray(solution.countBits(5));

    }

    static void printArray(int[] arr) {
        for(int a: arr) {
            System.out.print("[" + a + "]");
        }
    }
}
