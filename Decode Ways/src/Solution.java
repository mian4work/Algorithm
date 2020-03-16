/*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given a non-empty string containing only digits, determine the total number of ways to decode it.

    Example 1:

    Input: "12"
    Output: 2
    Explanation: It could be decoded as "AB" (1 2) or "L" (12).
    Example 2:

    Input: "226"
    Output: 3
    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class Solution {

    /**
     * Failed this one. Watched https://www.youtube.com/watch?v=qli-JCrSwuk
     *
     * It should start by thinking in this way: given "12345", the first two digits can be decoded as 'a' or 'l' because
     * 1 = a and 12 = l.
     *
     * So we do the a + "2345" (when it is a = 1) or l + "345" (when it is l = 12).
     * But if the first two digits is greater than 36 (for example, string "37231", we only take care of '3' as
     * c + "7231"
     *
     * When the string is empty, return 1. This needs to be thought again.
     *
     * When the first digit is 0, like "012", there is no string maps 0 or 01 so it returns 0.
     *
     * Do all string recursively.
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        return numWays(s, s.length());
    }

    public int numDecodingsMemo(String s) {
        Integer[] memo = new Integer[s.length() + 1];
        return numWays(s, s.length());
    }

    /**
     *
     * @param s the original string
     * @param len is the length of the rest sub string.
     * @return
     */
    private int numWays(String s, int len) {
        //when it is an empty string
        if(len == 0) {
            return 1;
        }

        //check if the first digit in the sub string is 0
        int start = s.length() - len;
        if(s.charAt(start) == '0') {
            return 0;
        }

        //process the first digit
        int result = numWays(s, len - 1);
        //process first digit + second digit. check if rest length >= 2 and if it is > 36
        if(len >= 2 && Integer.valueOf(s.substring(start, start + 1)) <= 36) {
            result += numWays(s, len - 2);
        }

        return result;
    }

    /**
     * Use an Integer array to memorize the result. The key is any given length of data, the ways are the same
     * @param s
     * @param len
     * @param memo
     * @return
     */
    private int numWays(String s, int len, Integer[] memo) {
        //when it is an empty string
        if(len == 0) {
            return 1;
        }

        //check if the first digit in the sub string is 0
        int start = s.length() - len;
        if(s.charAt(start) == '0') {
            return 0;
        }

        if(memo[len] != null) {
            return memo[len];
        }

        //process the first digit
        int result = numWays(s, len - 1);
        //process first digit + second digit. check if rest length >= 2 and if it is > 36
        if(len >= 2 && Integer.valueOf(s.substring(start, start + 1)) <= 36) {
            result += numWays(s, len - 2);
        }
        memo[len] = result;
        return result;
    }
}
