
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	    Solution solution = new Solution();

	    boolean[][] board = new boolean[][]{{false, false, false, false},
                {true, true, false, true},
                {false, false, false, false},
                {false, false, false, false}
        };

	    System.out.println(solution.minSteps(board, 3, 0, 0, 0));
        //solution.minStepsDFS(board, new Point(3, 0), new Point(0, 0));
    }
}
