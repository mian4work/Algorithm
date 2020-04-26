/*
    Given two strings text1 and text2, return the length of their longest common subsequence.

    A subsequence of a string is a new string generated from the original string with some characters(can be none)
    deleted without changing the relative order of the remaining characters.
    (eg, "ace" is a subsequence of "abcde" while "aec" is not).
    A common subsequence of two strings is a subsequence that is common to both strings.

    If there is no common subsequence, return 0.

    Example 1:

    Input: text1 = "abcde", text2 = "ace"
    Output: 3
    Explanation: The longest common subsequence is "ace" and its length is 3.

    Example 2:

    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.

    Example 3:

    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.


    Constraints:
    1 <= text1.length <= 1000
    1 <= text2.length <= 1000
    The input strings consist of lowercase English characters only.
 */
public class Solution {
    /**
     * Failed at this one. A good learn from the following video:
     *
     * @see <a href="https://www.youtube.com/watch?v=ASoaQq66foQ">Lonest Common Subsequence</a>
     *
     * To start, analyse the problem by breaking it into a sub problem with optimal solution. For example "abc" and "aec"
     *      1. a recursion function looks like lsc("abc", "aec")
     *      2. looking from back: c == c, then we know it is 1
     *      3. remove last c ("ab", "ae") and b != e. we then get two problem to solve:
     *          remove last char of each string and compare which one has longest common subsequence:
     *              max(lsc("ab" "a"), lsc("a", "ae")) ----> max(1, 1) = 1 see below
     *              look at first: ("ab", "a"), b != a we get:
     *              max(lcs("a", "a"), lcs("ab", "")) so the result is 1
     *
     * Based on above thought, we can design a 2D dp: row is chars in one string and col is chars in another.
     *      at any cell [i,j]:
     *          if (row char) == (col char): we check the max len without this char, which is the value in [i-1,j-1]
     *              so dp[i][j] = dp[i-1][j-1] + 1
     *          if (row char) != (col char): we compare between no-row char situation with no-col char situation:
     *              which are respectively [i-1, j] and [i, j-1]
     *              so dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int len1 = text1.length(), len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
