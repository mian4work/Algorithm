import java.awt.*;
import java.util.Arrays;
import java.util.Queue;

/*
    You are given an M by N matrix consisting of booleans that represents a board.
    Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

    Given this matrix, a start coordinate, and an end coordinate,
    return the minimum number of steps required to reach the end coordinate from the start.
    If there is no possible path, then return null. You can move up, left, down, and right.
    You cannot move through walls. You cannot wrap around the edges of the board.

    For example, given the following board:

    [[f, f, f, f],
    [t, t, f, t],
    [f, f, f, f],
    [f, f, f, f]]

    and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to
    reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere
    else on the second row.
 */
public class Solution {

    public Integer minSteps(boolean[][] board, int s1, int s2, int e1, int e2) {
        if(board == null || board.length == 0) {
            return null;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] dp = new int[board.length][board[0].length];

        dp[s1][s2] = 0;
        helper(board, visited, dp, s1, s2, e1, e2);

        return dp[e1][e2] == 0 ? null : dp[e1][e2];
    }

    void helper(boolean[][] board, boolean[][] visited, int[][] dp, int s1, int s2, int e1, int e2) {
        if(s1 == e1 && s2 == e2) {
            return;
        }

        visited[s1][s2] = true;

        if(s1 - 1 >= 0 && !board[s1 - 1][s2] && !visited[s1 - 1][s2]) {
            dp[s1 - 1][s2] = dp[s1][s2] + 1;
            helper(board, visited, dp, s1 - 1, s2, e1, e2);
        }

        if(s1 + 1 < board.length && !board[s1 + 1][s2] && !visited[s1 + 1][s2]) {
            dp[s1 + 1][s2] = dp[s1][s2] + 1;
            helper(board, visited, dp, s1 + 1, s2, e1, e2);
        }

        if(s2 - 1 >= 0 && !board[s1][s2 - 1] && !visited[s1][s2 - 1]) {
            dp[s1][s2 - 1] = dp[s1][s2] + 1;
            helper(board, visited, dp, s1, s2 - 1, e1, e2);
        }

        if(s2 + 1 < board[0].length && !board[s1][s2 + 1] && !visited[s1][s2 + 1]) {
            dp[s1][s2 + 1] = dp[s1][s2 + 1] + 1;
            helper(board, visited, dp, s1, s2 + 1, e1, e2);
        }
    }

    /**
     * Line by line dp. Won't work because the line below the wall can't be calculated correctly.
     *
     * @param board
     * @param start
     * @param end
     * @return
     */
    public Integer minStepsLineByLine(Boolean[][] board, Point start, Point end) {

        Integer[][] dp = new Integer[board.length][board[0].length];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(board[i][j]) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                min = j - 1 >= 0 && !board[i][j - 1] ? Math.min(min, dp[i][j - 1]) : min;
                min = j + 1 < dp[i].length && !board[i][j + 1] ? Math.min(min, dp[i][j + 1]) : min;
                min = i - 1 >= 0 && !board[i - 1][j] ? Math.min(min, dp[i - 1][j]) : min;
                min = i + 1 < dp.length && board[i + 1][j] ? Math.min(min, dp[i + 1][j]) : min;

                dp[i][j] = i == 0 && j == 0 ? 1 : min + 1;
            }
        }

        return dp[end.x][end.y] - dp[start.x][start.y];
    }

//    public Integer minStepsBackTracing(Boolean[][] board, Point start, Point end) {
//        boolean[][] visited = new boolean[board.length][board[0].length];
//        IntegerWrapper sum = new IntegerWrapper(0);
//        move(board, visited, sum, start, end);
//        return sum.value;
//    }

//    private void move(Boolean[][] board, boolean[][] visited, IntegerWrapper sum, Point start, Point end) {
//        if(start.equals(end)) {
//            sum.plusOne();
//            return;
//        }
//
//        if(visited[start.x][start.y]) {
//            return;
//        }
//
//        if(board[start.x][start.y]) {
//            return;
//        }
//
//        visited[start.x][start.y] = true;
//        //check up
//        if(start.x - 1 >= 0) {
//            move(board, visited, sum.plusOne(), new Point(start.x - 1, start.y), end);
//        }
//        //check down
//        if(start.x + 1 < board.length) {
//            move(board, visited, sum.plusOne(), new Point(start.x + 1, start.y), end);
//        }
//        //check left
//        if(start.y - 1 >= 0) {
//            move(board, visited, sum.plusOne(), new Point(start.x, start.y - 1), end);
//        }
//        //check right
//        if(start.y + 1 < board[0].length) {
//            move(board, visited, sum.plusOne(), new Point(start.x, start.y + 1), end);
//        }
//    }
//
//    class IntegerWrapper {
//        Integer value;
//        public IntegerWrapper(Integer value) {
//            this.value = value;
//        }
//
//        public IntegerWrapper plusOne() {
//            value += 1;
//            return this;
//        }
//    }

//    public Integer minStepsDFS(Boolean[][] board, Point start, Point end) {
//        Integer[][] sum = new Integer[board.length][board[0].length];
//        for(int i = 0; i < sum.length; i++) {
//            Arrays.fill(sum[i], Integer.MAX_VALUE);
//        }
//
//        Boolean[][] visited = new Boolean[board.length][board[0].length];
//        for(int i = 0; i < visited.length; i++) {
//            Arrays.fill(visited[i], false);
//        }
//
//        sum[start.x][start.y] = 1;
//        visited[start.x][start.y] = true;
//
//        if(!board[start.x - 1][start.y]) {
//            sum[start.x - 1][start.y] = 2;
//            visited[start.x - 1][start.y] = true;
//        }
//
//        if(!board[start.x][start.y - 1]) {
//            sum[start.x][start.y - 1] = 2;
//            visited[start.x][start.y - 1] = true;
//        }
//
//        minSteps(board, visited, sum, new Point(start + 1, end);
//        Integer result = sum[end.x][end.y];
//        return result == Integer.MAX_VALUE ? null : result;
//    }

//    private Integer minSteps(Boolean[][] board, Boolean[][] visited, Integer[][] sum, Point start, Point end) {
//        if(start.x < 0 || start.x > board.length - 1 || start.y < 0 || start.y > board[0].length - 1) {
//            return Integer.MAX_VALUE;
//        }
//
//        if(board[start.x][start.y]) {
//            return Integer.MAX_VALUE;
//        }
//
//        if(visited[start.x][start.y]) {
//            return sum[start.x][start.y];
//        }
//
//        if(start.x == end.x && start.y == end.y) {
//            return sum[start.x][start.y];
//        }
//
//        int minSum = Integer.MAX_VALUE;
//        minSum = Math.min(minSum, minSteps(board, visited, sum, new Point(start.x - 1, start.y), end)); //left
//        minSum = Math.min(minSum, minSteps(board, visited, sum, new Point(start.x + 1, start.y), end)); //right
//        minSum = Math.min(minSum, minSteps(board, visited, sum, new Point(start.x, start.y - 1), end)); //up
//        minSum = Math.min(minSum, minSteps(board, visited, sum, new Point(start.x, start.y + 1), end)); //down
//        sum[start.x][start.y] = minSum + 1;
//        visited[start.x][start.y] = true;
//
//        return sum[start.x][start.y];
//    }

//    int moveBSF(Boolean[][] board, Boolean[][] visited, Point end, Queue<Point> queue) {
//
//        if(queue.isEmpty()) {
//            return 0;
//        }
//        Point head = queue.poll();
//        //if head == end, return 1
//        if(head == end) {
//            return 1;
//        }
//
//        //if head is out of boundary return 0
//        if(head.x < 0 || head.x > board.length - 1
//                || head.y < 0 || head.y > board[0].length - 1) {
//            return 0;
//        }
//
//        //if head in visited return 0
//
//        if(visited[head.x][head.y]) {
//            return 0;
//        }
//
//        //if head is a wall return 0
//        if(board[head.x][head.y]) {
//            return 0;
//        }
//
//        //queue add left right up down
//        queue.add(new Point(head.x - 1, head.y));
//        queue.add(new Point(head.x + 1, head.y));
//        queue.add(new Point(head.x, head.y - 1));
//        queue.add(new Point(head.x, head.y + 1));
//
//        //return min sum of left right up down
//        int leftSum =
//
//
//    }

//    public Integer minStep(boolean[][] board, Point start, Point end) {
//        if(board == null || board.length == 0 || start == null || end == null) {
//            return null;
//        }
//
//        boolean[][] visited = new boolean[board.length][board[0].length];
//
//        return moveDFS(board, visited, start, end);
//    }
//
//    Integer moveDFS(boolean[][] board, boolean[][] visited, Point start, Point end) {
//        if(start == end) {
//            return 1;
//        }
//
//        if(start.x < 0 || start.x > board.length - 1
//                || start.y < 0 || start.y > board[0].length - 1) {
//            return null;
//        }
//
//        if(visited[start.x][start.y]) {
//            return null;
//        }
//
//        //if head is a wall return 0
//        if(board[start.x][start.y]) {
//            return null;
//        }
//
//        visited[start.x][start.y] = true;
//
//        Integer up = moveDFS(board, visited, new Point(start.x - 1, start.y), end);
//        Integer down = moveDFS(board, visited, new Point(start.x + 1, start.y), end);
//        Integer left = moveDFS(board, visited, new Point(start.x, start.y - 1), end);
//        Integer right = moveDFS(board, visited, new Point(start.x, start.y + 1), end);
//
//        if(up == null && down == null && left == null && right == null) {
//            return null;
//        }
//
//        Integer min = Integer.MAX_VALUE;
//        min = up != null ? Math.min(up + 1, min) : min;
//        min = down != null ? Math.min(down + 1, min) : min;
//        min = left != null ? Math.min(left + 1, min) : min;
//        min = right != null ? Math.min(right + 1, min) : min;
//
//        return min;
//    }
}
