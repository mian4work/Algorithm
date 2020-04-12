public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    int[] arr = new int[]{2,7,4,1,8,1};
	    solution.insertSort(arr, 0, arr.length - 1);
	    System.out.println(solution.lastStoneWeight(arr));
	    return;
    }
}
