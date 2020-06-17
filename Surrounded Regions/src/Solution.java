/*
    Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

    A region is captured by flipping all 'O's into 'X's in that surrounded region.

    Example:

    X X X X
    X O O X
    X X O X
    X O X X
    After running your function, the board should be:

    X X X X
    X X X X
    X X X X
    X O X X

    Explanation:

    Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not
    flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be
    flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class Solution {
    /**
     * To solve this problem, we need to find the O along the border and check if it is connected with other Os.
     *
     *      1. loop along the boarder row is 0 or len - 1 and column is 1 or [0].len - 2 (notice the first and last
     *          element has been processed by first loop.
     *      2. if we find a O, we mark it to C and from it, move around to check if it is connected with O recursively.
     *      3. loop through 2D array,
     *          if it is X, do nothing
     *          if it is C, change it to O
     *          if it is O, change it to X
     *          
     * @param board
     */
    public void solve(char[][] board) {
        //use C as O connected to border
        if(board == null || board.length == 0) {
            return;
        }

        //go through the border and check if there are Os
        //first and last rows with column length
        for(int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O') {
                mark(board, 0, i);
            }

            if(board[board.length - 1][i] == 'O') {
                mark(board, board.length -1, i);
            }
        }

        //second and second last columns with row length
        //because first and last has been marked with loop above.
        for(int i = 1; i < board.length - 1; i++) {
            if(board[i][0] == 'O') {
                mark(board, i, 0);
            }

            if(board[i][board[0].length - 1] == 'O') {
                mark(board, i, board[0].length - 1);
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'C') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void mark(char[][] board, int i, int j) {
        board[i][j] = 'C';

        //up
        if(i > 0 && board[i - 1][j] == 'O') {
            mark(board, i - 1, j);
        }

        //down
        if(i < board.length - 1 && board[i + 1][j] == 'O') {
            mark(board, i + 1, j);
        }

        //left
        if(j > 0 && board[i][j - 1] == 'O') {
            mark(board, i, j - 1);
        }

        //right
        if(j < board[0].length - 1 && board[i][j + 1] == 'O') {
            mark(board, i, j + 1);
        }
    }
}
