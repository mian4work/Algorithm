/*
    A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e.,
    maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1].
    A rat starts from source and has to reach the destination. The rat can move only in two directions:
    forward and down.

    In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source
    to destination. Note that this is a simple version of the typical Maze problem.
    For example, a more complex version can be that the rat can move in 4 directions and a more complex version
    can be with a limited number of moves.

    https://www.geeksforgeeks.org/wp-content/uploads/ratinmaze_filled11.png
 */
public class Solution {
    int n;
    int[][] path;

    /**
     * A simple backtracking problem.
     * 
     * @param board
     * @return
     */
    public int[][] ratMove(int[][] board) {
        n = board.length;
        if(n == 0 || board[n - 1][n - 1] == 0) {
            return null;
        }

        path = board;
        if(move(board, 0, 0)) {
            return path;
        } else {
            return null;
        }
    }

    boolean move(int[][] board, int i, int j) {
        if(i == n - 1 && j == n - 1) {
            path[i][j] = 2;
            return true;
        }

        if(i > n - 1 || j > n - 1) {
            return false;
        }

        if(board[i][j] == 0) {
            return false;
        } else {
            path[i][j] = 2;
        }

        return move(board, i + 1, j) || move(board, i, j + 1);
    }
}
