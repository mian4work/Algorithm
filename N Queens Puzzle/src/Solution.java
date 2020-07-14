import java.util.ArrayList;
import java.util.List;

/*
    This problem was asked by Microsoft.

    You have an N by N board. Write a function that, given N, returns the number of possible arrangements of the board
    where N queens can be placed on the board without threatening each other, i.e. no two queens share the same row,
    column, or diagonal.
 */
public class Solution {
//    public int nQueens(int N) {
//        if(N == 0) {
//            return 0;
//        }
//
//    }
//
//    boolean place(int[] queens, int col) {
//
//    }

    /**
     * Place the Q row by row by using
     * @param N
     * @return
     */
    public int nQueensArray(int N) {
        if (N == 0) {
            return 0;
        }

        int count = 0;
        for(int q = 0; q < N; q++) {
            List<Integer> queens = new ArrayList<>();
            queens.add(0, q);
            row:
            for(int row = 1; row < N; row++) {
                boolean rowPlaced = false;
                column:
                for(int col = 0; col < N; col++) {
                    queens.add(row, col);
                    if (!isLastValid(queens)) {
                        queens.remove(queens.size() - 1); //backtracking
                    } else {
                        rowPlaced = true;
                        break column;
                    }
                }
                if(!rowPlaced) {
                    break row;
                }
            }
            if(queens.size() == N) {
                count++;
            }
        }

        return count;
    }

    boolean isLastValid(List<Integer> queens) {
        int x = queens.size() - 1, y = queens.get(x);
        for(int i = 0; i < queens.size() - 1; i++) {
            int row = i, col = queens.get(row);
            if(row == x || col == y || row + col == x + y || col - row == y - x) {
                return false;
            }
        }

        return true;
    }

    boolean isLastValid(int[] queens) {
        int x = queens.length - 1, y = queens[x];
        for(int i = 0; i < queens.length - 1; i++) {
            int row = i, col = queens[row];
            if(row == x || col == y || row + col == x + y || col - row == y - x) {
                return false;
            }
        }

        return true;
    }
}
