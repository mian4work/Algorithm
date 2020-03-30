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
     * The concept is simple. Just use a Set to check if it is duplicated (set.add() returns true/false)
     *
     * But for each element i, when you add it and find, oh shit, it is a duplicated one, how to do?
     * Simple, just get the substring from pointer to i - 1 !!!
     *
     * This is what I learnt.
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, pointer = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if(!set.add(s.charAt(i))) {
                max = Math.max(max, s.substring(pointer, i - 1).length());
                set.remove(s.charAt(pointer));
                pointer++;
            }
        }
        return max;
    }
}
