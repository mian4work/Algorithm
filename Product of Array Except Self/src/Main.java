public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    printArray(solution.productExceptSelf(new int[]{1,2,3,4}));
    }

    static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print("[" + i + "]");
        }
        System.out.println();
    }
}
