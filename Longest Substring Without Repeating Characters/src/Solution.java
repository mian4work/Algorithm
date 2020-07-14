import java.util.HashSet;
import java.util.Set;

/*
    Given a string, find the length of the longest substring without repeating characters.

    Example 1:

    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.
    Example 2:

    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:

    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */
public class Solution {

    /**
     * The concept is simple. Just use a Set to check if it is duplicated (set.contains returns true/false)
     *
     * Once you find a dup, create a new HashSet and set pointer to i, and add i into set
     *
     * Don't forget the last part of string after the loop is finished.
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        int max = 0, pointer = 0, i = 0;
        Set<Character> set = new HashSet<>();

        for(i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                max = Math.max(max, s.substring(pointer, i).length()); // i is not included
                set = new HashSet<>();
                pointer = i;
            }
            set.add(s.charAt(i));
        }

        max = Math.max(max, s.substring(pointer, i).length());
        return max;
    }
}
