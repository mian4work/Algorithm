/*
    Given a string s and a string t, check if s is subsequence of t.

    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
    of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a
    subsequence of "abcde" while "aec" is not).

    Follow up:
    If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if
    T has its subsequence. In this scenario, how would you change your code?

    Example 1:

    Input: s = "abc", t = "ahbgdc"
    Output: true

    Example 2:

    Input: s = "axc", t = "ahbgdc"
    Output: false


    Constraints:

    0 <= s.length <= 100
    0 <= t.length <= 10^4
    Both strings consists only of lowercase characters.
 */
public class Solution {
    /**
     * Two pointer solution.
     *
     * I should use found as an index instead of loop. when found == s.length, that means true.
     *
     * And the code can be simplified. See next methond
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int index = 0, found = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while(index < t.length()) {
                if(t.charAt(index) == c) {
                    found++;
                    index++;
                    break;
                }
                index++;
            }

            if(index > t.length() - 1) {
                break;
            }
        }

        return found == s.length();
    }

    /**
     * Same idea but more concise code.
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequenceLeetCode(String s, String t) {
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }
}
