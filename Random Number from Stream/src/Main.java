public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    for(int i = 0; i < 100; i++) {
            System.out.println(solution.pick(new int[]{2, 5, 7, 3, 5, 7, 1, 9, 2, 4, 0, 1, 2, 4, 5}));
        }
    }
}
