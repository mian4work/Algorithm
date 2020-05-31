/*
    Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

    You have the following 3 operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character
    Example 1:

    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')
    Example 2:

    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
 */
public class Solution {
    /**
     * The previous solution is wrong.
     *
     * To solve this problem, we can use dp
     *      1. create a 2d array where row is word1's len + 1 and col is word2's len + 1
     *      2. first row or col (index is 0) means if word1 or word2 is empty, then what is the distance between each
     *         sub word?
     *         for example, "hello" and "":
     *              "h" and "": distance is 1
     *              "he" and "": distance is 2
     *              "hel" and "": distance is 3
     *              etc.
     *         so first row or col is populated with the index itself
     *      3. in dp table, given any i and j
     *          if char at word1[i] == word2[j], then the distance is the same with word1[i-1] and word2[j-1] which is
     *          dp[i-1][j-1]
     *          if word1[i] != word2[j], then the distance is 1 + (min of left, up and dia)
     *
     *   ref: https://www.youtube.com/watch?v=We3YDTzNXEk
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return 0;
        }
        int len1 = word1.length() + 1, len2 = word2.length() + 1;
        int[][] dp = new int[len1][len2];
        for(int i = 0; i < len1; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j < len2; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i < len1; i++) {
            for(int j = 1; j < len2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[len1 - 1][len2 - 1];
    }
}
