import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    int[] stream = new int[]{2, 5, 7, 3, 5, 7, 1, 9, 2, 4, 0, 1, 2, 4, 5};
	    for(int i = 0; i < 100; i++) {
            System.out.println("The selected element with solution is " + solution.pick(stream) + " in comparison with " + stream[new Random().nextInt(stream.length)]);
        }
    }
}
