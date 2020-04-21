import java.util.ArrayList;
import java.util.List;

/*
    (This problem is an interactive problem.)

    A binary matrix means that all elements are 0 or 1. For each individual row of the matrix,
    this row is sorted in non-decreasing order.

    Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it.
    If such index doesn't exist, return -1.

    You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

    BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
    BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.

    Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.
    Also, any solutions that attempt to circumvent the judge will result in disqualification.

    For custom testing purposes you're given the binary matrix mat as input in the following four examples.
    You will not have access the binary matrix directly.



    Example 1:

    Input: mat = [
    [0,0]
    [1,1]
    ]
    Output: 0


    Example 2:

    Input: mat = [
    [0,0]
    [0,1]
    ]
    Output: 1

    Example 3:

    Input: mat = [
    [0,0]
    [0,0]
    ]
    Output: -1

    Example 4:

    Input: mat = [
    [0,0,0,1]
    [0,0,1,1]
    [0,1,1,1]
    ]
    Output: 1


    Constraints:

    1 <= mat.length, mat[i].length <= 100
    mat[i][j] is either 0 or 1.
    mat[i] is sorted in a non-decreasing way.
*/
public class Solution {
    /**
     * Done by me.
     *
     * Algorithm: Since is sorted, all 1s are on the left. So we can start searching from upper right corner (0, len - 1)
     *      1. when it is 0, that means it is not the leftmost one, move down to next row
     *      2. when it is 1, record the current leftmost and then we need to check two cases:
     *          first, if the left side is 1, we need move left to find the leftmost
     *          second, if the left side is 0, we move down to check another row
     *      3. record founded leftmost on the way to the left or bottom border.
     *
     * This image shows a better solution: <img src="https://assets.leetcode.com/users/hiepit/image_1587490344.png"/>
     *
     * @param binaryMatrix
     * @return
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int[] ans = new int[]{-1};
        leftMost(binaryMatrix, 0, binaryMatrix.dimensions().get(1) - 1, ans);
        return ans[0];
    }

    void leftMost(BinaryMatrix binaryMatrix, int x, int y, int[] ans) {
        int m = binaryMatrix.dimensions().get(0);

        if(x > m - 1 || y < 0) {
            return;
        }

        if(binaryMatrix.get(x, y) == 0) {
            //move down
            leftMost(binaryMatrix, x + 1, y, ans);
        } else if(binaryMatrix.get(x, y) == 1) {
            ans[0] = y;
            if(y - 1 < 0 || binaryMatrix.get(x, y - 1) == 1) {
                //move left
                leftMost(binaryMatrix, x, y - 1, ans);
            } else {
                //move down
                leftMost(binaryMatrix, x + 1, y, ans);
            }
        }
    }
}

class BinaryMatrix {
    int[][] matrix;
    public BinaryMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int get(int x, int y) {
        return matrix[x][y];
    }

    public List<Integer> dimensions() {
        List<Integer> dim = new ArrayList<>();
        dim.add(0, matrix.length);
        dim.add(1, matrix[0].length);
        return dim;
    }
}
