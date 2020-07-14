public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));

        //System.out.println(solution.kthSmallest(root, 4));
    }

    static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print("[" + arr[i] + "]");
        }

        System.out.println();
    }
}
