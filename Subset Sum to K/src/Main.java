public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
	    //print(solution.subSetBackTracking(new int[]{12, 1, 61, 5, 9, 2}, 24));
        System.out.println(solution.subSetDynamicProgramming(new int[]{12, 1, 61, 5, 9, 2}, 65));
	    LeetCode leetCode = new LeetCode();
	    leetCode.subarraySum(new int[]{-1, -1, 1}, 1);
    }

    static void print(int[] arr) {
        if(arr == null) {
            System.out.println("not found");
        }
        for(Integer i : arr) {
            System.out.print("[" + i + "]");
        }
        System.out.println();
    }
}
