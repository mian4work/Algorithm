/*
    Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
    In other words, one of the first string's permutations is the substring of the second string.

    Example 1:

    Input: s1 = "ab" s2 = "eidbaooo"
    Output: True
    Explanation: s2 contains one permutation of s1 ("ba").

    Example 2:

    Input:s1= "ab" s2 = "eidboaoo"
    Output: False


    Note:

    The input strings only contain lower case letters.
    The length of both given strings is in range [1, 10,000].

    good explanation.

    https://www.youtube.com/watch?v=-rcfE1Tj2E0
 */
public class Solution {
    /**
     * My own solution. It is not the most efficient but easy to understand.
     *
     * Create two 26 int arrays. One is for s1 and one is for s2.
     *      1. accumulate the arrays with (char - 'a') to remember how many chars in one slot.
     *      2. define a two pointers: start and end.
     *      3. moving the end pointer first to length of s1, and decrement the both arrays at each chars
     *      4. compare two arrays to see if at certain slots, the numbers are the same.
     *      5. if they are the same, return try, otherwise moving forward
     *      6. with known start == 0 and know end pointer, using the sliding window
     *      7. each step, when start point is out of range, increment both arrays at start char
     *      8. each step, decrement both arrays at end char
     *      9. compare two arrays along the way.
     *
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }

        int[] chars1 = new int[26], chars2 = new int[26];
        int start = 0, end = 0;
        while(start < s2.length()) {
            chars2[s2.charAt(start) - 'a']++;
            if(start < s1.length()) {
                chars1[s1.charAt(start) - 'a']++;
            }
            start++;
        }

        start = 0;
        while(end < s1.length()) {
            char temp = s2.charAt(end);
            chars1[temp - 'a']--;
            chars2[temp - 'a']--;
            end++;
        }

        if(equals(chars1, chars2)) {
            return true;
        }

        //now start is at 0 and end is at s1.length so we do start before start++
        while(end < s2.length()) {
            char temp = s2.charAt(start);
            chars1[temp - 'a']++;
            chars2[temp - 'a']++;
            start++;

            temp = s2.charAt(end);
            chars1[temp - 'a']--;
            chars2[temp - 'a']--;
            end++;

            if(equals(chars1, chars2)) {
                return true;
            }
        }

        return false;
    }

    boolean equals(int[] chars1, int[] chars2) {
        for(int i = 0; i < chars1.length; i++) {
            if(chars1[i] != 0 && chars2[i] != chars1[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * This is a better way but it is hard to understand.
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusionBetter(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }

        int[] chars = new int[26];
        for(char c : s1.toCharArray()) {
            chars[c - 'a']++;
        }

        int start = 0, end = 0, len = 0;
        while(end < s1.length()) {
            char temp = s2.charAt(end);
            chars[temp - 'a']--;
            if(chars[temp - 'a'] >= 0) {
                len++;
            }

            end++;
        }

        if(len == s1.length()) {
            return true;
        }

        while(end < s2.length()) {
            char temp = s2.charAt(start);
            if(chars[temp - 'a'] >= 0) {
                len--;
            }
            chars[temp - 'a']++;
            start++;

            temp = s2.charAt(end);
            chars[temp - 'a']--;
            if(chars[temp - 'a'] >= 0) {
                len++;
            }
            end++;

            if(len == s1.length()) {
                return true;
            }
        }

        return false;
    }
}
