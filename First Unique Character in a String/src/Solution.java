import java.util.HashMap;
import java.util.Map;

/*
    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Examples:

    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.

    Note: You may assume the string contain only lowercase letters.
 */
public class Solution {

    /**
     * The difficult part of this problem is to get the FIRST non repeating char.
     *
     * My solution is to use a map to record if a char is unique. If it appears one more time, mark it false.
     * Then traverse the arr and find the first one in map which is true.
     *
     * Not the best way to do it but is passed. The difficulty is how to try not to do the second loop.
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), true);
            } else if (map.get(s.charAt(i))) {
                map.put(s.charAt(i), false);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))) {
                return i;
            }
        }

        return -1;
    }
}
