/*
    You are given a string s containing lowercase English letters, and a matrix shift,
    where shift[i] = [direction, amount]:

    direction can be 0 (for left shift) or 1 (for right shift).
    amount is the amount by which string s is to be shifted.
    A left shift by 1 means remove the first character of s and append it to the end.
    Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
    Return the final string after all operations.



    Example 1:
    Input: s = "abc", shift = [[0,1],[1,2]]
    Output: "cab"
    Explanation:
    [0,1] means shift to left by 1. "abc" -> "bca"
    [1,2] means shift to right by 2. "bca" -> "cab"

    Example 2:
    Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
    Output: "efgabcd"
    Explanation:
    [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
    [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
    [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
    [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"


    Constraints:

    1 <= s.length <= 100
    s only contains lower case English letters.
    1 <= shift.length <= 100
    shift[i].length == 2
    0 <= shift[i][0] <= 1
    0 <= shift[i][1] <= 100
 */
public class Solution {
    /**
     * There are two key points to solve this problem:
     *      1. Since left move can cancel right move, so calculate the final shift and move it once.
     *      2. If the |left - right| > string length, reduce it until the move steps are less than the length.
     *      
     * @param s
     * @param shift
     * @return
     */
    public String stringShift(String s, int[][] shift) {
        if(s == null || s.length() == 0 || shift == null || shift.length == 0) {
            return s;
        }

        //first calculate the final shift, left move cancels right move
        int left = 0, right = 0;
        for(int i = 0; i < shift.length; i++) {
            if(shift[i][0] == 0) {
                left += shift[i][1];
            } else if(shift[i][0] == 1) {
                right += shift[i][1];
            }
        }

        //doing shift
        StringBuilder builder = new StringBuilder();
        int n = Math.abs(left - right);
        while(n > s.length()) {
            n -= s.length();
        }
        if(left == right) {
            return s;
        } else if(left > right) {
            builder.append(s.substring(0, n));
            builder.insert(0, s.substring(n));
            return builder.toString();
        } else if(left < right) {
            builder.append(s.substring(s.length() - n));
            builder.append(s.substring(0, s.length() - n));
            return builder.toString();
        }

        return s;
    }
}
