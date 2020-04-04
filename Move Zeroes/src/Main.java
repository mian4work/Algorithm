public class Main {

    public static void main(String[] args) {
	    int[] nums = new int[]{0,1,0,3,12};
	    print(nums);
	    Solution solution = new Solution();
	    solution.moveZeroes(nums);
	    print(nums);
    }

    private static void print(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            System.out.print("[" + nums[i] + "]");
        }
        System.out.println();
    }
}
