/*
    You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
    Check if these points make a straight line in the XY plane.

    Example 1:
    Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
    Output: true

    Example 2:
    Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
    Output: false

    Constraints:

    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates contains no duplicate point.
 */
public class Solution {
    /**
     * The correct way to calculate this is to calculate the "slop" of a line.
     *
     * To get the first two points (firstX, firstY) and (secondX, secondY), use:
     *      slop = (secondY - firstY) / (secondX - firstX)
     *
     * Then for each point, calculate the "slop" against firstX, firstY,
     *      (iY - firstY) / (iX - firstX) == (secondY - firstY) / (secondX - firstX) or
     *      (iY - firstY) * (secondX - firstX) == (iX - firstX) * (secondY - firstY)
     * if it doesn't equal to slop, return false. otherwise, return true.
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates == null || coordinates.length == 0) {
            return false;
        }

        if(coordinates.length == 2) {
            return true;
        }
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];

        for(int i = 2; i < coordinates.length; i++) {
            int xi = coordinates[i][0], yi = coordinates[i][1];
            if(!(((yi - y0) * (x1 - x0)) == ((xi - x0) * (y1 - y0)))) {
                return false;
            }
        }

        return true;
    }
    /**
     * My first try is totally wrong. I just think it as a two D array which we evaluate horizantal, vertical and cross.
     *
     * This is totally wrong.
     *
     * @param coordinates
     * @return
     */
    public boolean checkStraightLineFirstTry(int[][] coordinates) {
        if(coordinates == null || coordinates.length == 0) {
            return false;
        }

        if(coordinates.length <= 2) {
            return true;
        }

        boolean right = coordinates[1][1] - coordinates[1][0] == coordinates[0][1] - coordinates[0][0];
        boolean  left = coordinates[1][1] + coordinates[1][0] == coordinates[0][1] + coordinates[0][0];
        boolean hori = coordinates[0][0] == coordinates[1][0];
        boolean vert = coordinates[0][1] == coordinates[1][1];

        if(!(right || left || hori || vert)) {
            return false;
        }

        for(int i = 2; i < coordinates.length; i++) {
            if(right && coordinates[i][1] - coordinates[i][0] != coordinates[0][1] - coordinates[0][0])             {
                return false;
            }

            if(left && coordinates[i][1] + coordinates[i][0] != coordinates[0][1] + coordinates[0][0])
            {
                return false;
            }

            if(hori && coordinates[i][0] != coordinates[0][0]) {
                return false;
            }

            if(vert && coordinates[i][1] != coordinates[0][1]) {
                return false;
            }
        }

        return true;
    }
}
