import java.util.ArrayList;
import java.util.List;

/*
    You have an N by N board. Write a function that returns the number of possible arrangements of the board
    where N queens can be placed on the board without threatening each other, i.e.
    no two queens share the same row, column, or diagonal.

    Another variation is to ask if it is possible to put N queens in N by N board.
 */
public class NQueensPuzzle {
    /**
     * Let's start by asking if it is possible to place N queens in N by N board.
     *
     * This is a very good video: https://www.youtube.com/watch?v=xouin83ebxE
     *
     * Algorithm:
     *      1. Place first Q in first row and first col [0, 0]
     *      2. Since we can't put two Queens in the same row:
     *      3. Try to place the second Q in the second row from col [0..n-1]
     *          For each col in second row, check if the second Q is threatening the first Q.
     *          1.1. if found one col which is not conflict
     *              Try to place the third Q in the third row from col [0..n-1] and so on.........
     *          1.2. if all cols are conflict, that means we need to re-think whether the first row placement is correct.
     *               so we return false and force the first Q to be put in different col in the first row.
     *               and so on........
     *
     * @param n
     * @return
     */
    public boolean nQueen(int n) {

        if(n <= 0) {
            return false;
        }

        List<Integer> board = new ArrayList<>();
        return helper(n, 0, board);
    }

    /**
     * Count how many ways to place N queens in a N by N board.
     *
     * @param n
     * @return
     */
    public int nQueenCount(int n) {

        if(n <= 0) {
            return 0;
        }

        List<Integer> board = new ArrayList<>();
        return sumHelper(n, 0, board);
    }

    /**
     * Using a list of int to keep tracking the position of Queue placed, where each index means a row and each value
     * means a column.
     *
     * Important:
     *      after trying one row, if col loop is down but we can't find the position for Queue, we need to clean the
     *      last added position.
     *
     * @param n
     * @param row
     * @param board
     * @return
     */
    private boolean helper(int n, int row, List<Integer> board) {
        //all Queens are placed. note the n is 1 based but row is 0 based.
        if(n == row) {
            return true;
        }

        for(int col = 0; col < n; col++) {
            if(!hasConflict(board, row, col)) {
                board.add(row, col);
                if(helper(n, row + 1, board)) { // it can directly use return but just for clarity.
                    return true;
                }
            }
        }

        //this means the queen can't placed in this row.
        if(board.size() > 0) {
            board.remove(board.size() - 1);
        }
        return false;
    }

    private int sumHelper(int n, int row, List<Integer> board) {
        //all Queens are placed. note the n is 1 based but row is 0 based.
        if(n == row) {
            return 1; // the last one is counted as one so the next method will add it into sum
        }

        int sum = 0;
        for(int col = 0; col < n; col++) {
            if(!hasConflict(board, row, col)) {
                board.add(row, col);
                int temp = sum + sumHelper(n, row + 1, board);
                return temp;
            }
        }

        //this means the queen can't placed in this row.
        if(board.size() > 0) {
            board.remove(board.size() - 1);
        }
        return sum;
    }

    /**
     * Check if the to be placed Queen [row, col] conflicts with existing Queens.
     *      1. Same row (i == row)
     *      2. Same column (board.get(i) == col)
     *      3. Same on Diagonal:
     *          use (row - column) and (row + column) to decide the existing Queens are on the diagonal positions.
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean hasConflict(List<Integer> board, int row, int col) {
        for(int i = 0; i < board.size(); i++) {
            if(i == row || board.get(i) == col
                    || i + board.get(i) == row + col
                    || i - board.get(i) == row - col) {
                return true;
            }
        }

        return false;
    }
}
