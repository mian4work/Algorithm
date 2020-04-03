/*
    Write an algorithm to determine if a number is "happy".

    A happy number is a number defined by the following process: Starting with any positive integer,
    replace the number by the sum of the squares of its digits, and repeat the process until
    the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy numbers.

    Example:

    Input: 19
    Output: true
    Explanation:
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
 */

public class Solution {

    /**
     * Recursively solve the problem. The key is to find the stopping point.
     *
     * Check 1..9, only 1 and 7 are the happy number. Use them to stop the recursion.
     *
     * Another way to end the loop is to use a Set. Add each computed result 'squareSum' into the set.
     * Once it is duplicated, that is not a happy number.
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if(n <= 0) {
            return false;
        }

        if(n / 10 < 1) {
            return n == 1 || n == 7 ? true : false;
        }

        int squareSum = 0;
        int remain = 0;
        int m = n; //n can be directly used but in order not to alter the original value, use m
        while(m > 0) {
            remain = m % 10;
            squareSum += remain * remain;
            m /= 10;
        }

        if(squareSum == 1) {
            return true;
        } else {
            return isHappy(squareSum);
        }
    }
}
