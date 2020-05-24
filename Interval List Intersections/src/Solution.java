import java.util.ArrayList;
import java.util.List;

/*
    Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

    Return the intersection of these two interval lists.

    (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
    The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as
    a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)



    Example 1: https://assets.leetcode.com/uploads/2019/01/30/interval1.png

    Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
    Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.


    Note:

    0 <= A.length < 1000
    0 <= B.length < 1000
    0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
    NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class Solution {
    /**
     * Idea got from this video: https://www.youtube.com/watch?v=Qh8ZjL1RpLI
     *
     * Suppose we have to intervals [a0, a1], [b0, b1]. There are two important part to solve the problem:
     *      1. check if they are overlap:
     *          compare one interval's start with another's end and vise versa, use == to make sure edge overlap
     *              a0 <= b1 && a1 >= b0
     *              this make sure two intervals overlap
     *      2. how to move to next element?
     *          use two pointer 'a' and 'b' for two group of intervals:
     *          compare the a1 and b1:
     *              if a1 > b1: b++
     *              else if b1 > a1: a++
     *              else if a1 == b1: a++, b++
     *
     *
     * @param A
     * @param B
     * @return
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0) {
            return new int[][]{};
        }

        List<int[]> list = new ArrayList<>();
        int ap = 0, bp = 0;
        while(ap < A.length && bp < B.length) {
            if(intersected(A[ap], B[bp])) {
                list.add(new int[]{Math.max(A[ap][0], B[bp][0]), Math.min(A[ap][1], B[bp][1])});
            }

            if(A[ap][1] > B[bp][1]) {
                bp++;
            } else if(A[ap][1] < B[bp][1]) {
                ap++;
            } else {
                ap++;
                bp++;
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

    boolean intersected(int[] a, int[] b) {
        if(a[0] <= b[1] && b[0] <= a[1]) {
            return true;
        }

        return false;
    }
}
