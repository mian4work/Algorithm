import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the
    following rules:

        1. Each row must contain the digits 1-9 without repetition.
        2. Each column must contain the digits 1-9 without repetition.
        3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

        https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png

    A partially filled sudoku which is valid.

    The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

    Example 1:

    Input:
    [
      ["5","3",".",".","7",".",".",".","."],
      ["6",".",".","1","9","5",".",".","."],
      [".","9","8",".",".",".",".","6","."],
      ["8",".",".",".","6",".",".",".","3"],
      ["4",".",".","8",".","3",".",".","1"],
      ["7",".",".",".","2",".",".",".","6"],
      [".","6",".",".",".",".","2","8","."],
      [".",".",".","4","1","9",".",".","5"],
      [".",".",".",".","8",".",".","7","9"]
    ]
    Output: true
    Example 2:

    Input:
    [
      ["8","3",".",".","7",".",".",".","."],
      ["6",".",".","1","9","5",".",".","."],
      [".","9","8",".",".",".",".","6","."],
      ["8",".",".",".","6",".",".",".","3"],
      ["4",".",".","8",".","3",".",".","1"],
      ["7",".",".",".","2",".",".",".","6"],
      [".","6",".",".",".",".","2","8","."],
      [".",".",".","4","1","9",".",".","5"],
      [".",".",".",".","8",".",".","7","9"]
    ]
    Output: false
    Explanation: Same as Example 1, except with the 5 in the top left corner being
        modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
    Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.
    The given board contain only digits 1-9 and the character '.'.
    The given board size is always 9x9.
 */
public class Solution {

    /**
     * Very smart solution.
     *
     * The whole idea of this solution is trying to use col to control the navigation
     *      1. control vertical (row) move
     *      2. control horizontal (column) move
     *      3. control vertical/horizontal (inside a block) move
     *
     * Always use '/' to jump 3 elements and use '%' to move one by one.
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9; row++) {
            /*
                for each row, create new Set to check if there are dups in rows,
                in columns and in blocks
             */
            Set<Character> rowSet = new HashSet<>();
            Set<Character> columnSet = new HashSet<>();
            Set<Character> blockSet = new HashSet<>();

            for(int col = 0; col < 9; col++) {

                /*
                    check rows. moving direction is from up to down
                    important part is use col as row index and row as col index!!!
                    because col is changing but row is unchanged in this loop.
                    add will return false when the char already in set.
                 */
                if(board[col][row] != '.' && !rowSet.add(board[col][row])) {
                    return false;
                }
                /*
                    check columns. easy to understand.
                    moving direction is from left to right.
                 */
                if(board[row][col] != '.' && !columnSet.add(board[row][col])) {
                    return false;
                }

                /*
                    for each box, it is tricky
                    1. we need to find the base row and base column
                    2. then move from left to right, as well as from up to down by three steps

                    for example:
                        1. box [(0, 0), (2, 2)]: base row is 0 and base column is 0
                        2. box [(0, 2), (2, 5)]: base row is 0 and base column is 1
                        3. box [(5, 2), (8, 5)]: base row is 2 and base column is 1
                        3. box [(5, 5), (8, 8)]: base row is 2 and base column is 2

                   so the base row is calculated as such:
                        baseRow = 3 * (row / 3) because base row is 0 or 3 or 6
                        baseColumn = 3 * (row % 3) because base column is 0 or 1 or 2
                 */
                int baseRow = 3 * (row / 3);
                int baseColumn = 3 * (row % 3);

                /*
                    now we can just use 'col' to control the move in the block.
                    when 'col' increase
                    the coordinate in one box is [baseRow + col / 3][baseColumn + col % 3]
                    [baseRow + col / 3]: take baseRow == 0 as an example:
                        when col in [0..2], row == baseRow + col/3 == 0
                        when col in [3..5], row == 1
                        when col in [6..8], row == 2
                        so the range is always in 0..2
                    [baseColumn + col % 3]: take baseColumn == 0 as an example:
                        when col in [0..2], col == baseColumn + col%3 == 0 or 1, 2
                        when col in [3..5], row == 0 or 1 or 2
                        when col in [6..8], row == 0 or 1 or 2
                        so it iterate through 0 to 2
                 */
                if(board[baseRow + col / 3][baseColumn + col % 3] != '.'
                        && !blockSet.add(board[baseRow + col / 3][baseColumn + col % 3])) {
                    return false;
                }
            }
        }

        return true;
    }
}
