/*
    Given an integer, write a function to determine if it is a power of two.

    Example 1:

    Input: 1
    Output: true
    Explanation: 20 = 1

    Example 2:

    Input: 16
    Output: true
    Explanation: 24 = 16

    Example 3:

    Input: 218
    Output: false
 */
public class Solution {
    /**
     * Nothing fancy. Just exclude the negative and zero.
     * 
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }

        while(n > 0) {
            if(n == 1) {
                return true;
            }

            if(n % 2 != 0) {
                return false;
            }

            n /= 2;
        }

        return true;
    }

    /**
     * The first try is wrong. Because I missed the negative value.
     *
     * For example -16 is false
     * @param n
     * @return
     */
    public boolean isPowerOfTwoFirstTry(int n) {
        int m = Math.abs(n);
        if(m == 0) {
            return false;
        }

        while(m > 0) {
            if(m == 1) {
                return true;
            }

            if(m % 2 != 0) {
                return false;
            }

            m /= 2;
        }

        return true;
    }
}
