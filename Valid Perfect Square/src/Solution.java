/*
    Given a positive integer num, write a function which returns True if num is a perfect square else False.

    Note: Do not use any built-in library function such as sqrt.

    Example 1:

    Input: 16
    Output: true

    Example 2:

    Input: 14
    Output: false
 */
public class Solution {
    /**
     * My first try. Time exceeds the limit.
     *
     * This is a simple binary search problem. Tried to change "end" to the half but still exceed the time limit.
     *
     * Damn, found the problem. It will be overflow if using int, instead, using long!!!
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if(num <= 1) {
            return true;
        }

        long start = 2, end = num / 2 + 1; //
        while(start <= end) {
            long mid = (start + end) / 2;
            if(mid * mid == num) {
                return true;
            } else if(mid * mid > num) {
                end = mid - 1;
            } else if (mid * mid < num) {
                start = mid + 1;
            }
        }

        return false;
    }
}
