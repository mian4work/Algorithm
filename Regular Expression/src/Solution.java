/*
    This problem was asked by Facebook.

    Implement regular expression matching with the following special characters:

    . (period) which matches any single character
    * (asterisk) which matches zero or more of the preceding element
    That is, implement a function that takes in a string and a valid regular expression and returns whether or not
    the string matches the regular expression.

    For example, given the regular expression "ra." and the string "ray", your function should return true.
    The same regular expression on the string "raymond" should return false.

    Given the regular expression ".*at" and the string "chat", your function should return true.
    The same regular expression on the string "chats" should return false.
*/
public class Solution {

    /**
     * My solution.
     *      1. Scan to see if the last '*' exists, remove the part before '*'.
     *      2. Scan rest of sub string with '.'
     * @param regex
     * @param s
     * @return
     */
    public boolean regex(String regex, String s) {
        if(s == null || s.length() == 0 || regex == null || s.length() < regex.length()) {
            return false;
        }

        //scan '*'. the last part of regex need to map last part of s
        StringBuilder sBuilder = new StringBuilder();
        StringBuilder rBuilder = new StringBuilder();
        int sp = s.length() - 1;
        for(int i = regex.length() - 1; i >= 0; i--) {
            if(regex.charAt(i) == '*') {
                if(rBuilder.toString().equals(sBuilder.toString())) {
                    return true;
                }
            }
            sBuilder.insert(0, s.charAt(sp--));
            rBuilder.insert(0, regex.charAt(i));
        }

        sBuilder = new StringBuilder();
        rBuilder = new StringBuilder();
        //scan '.'. the next char in s can be anything
        for(int i = 0; i < regex.length(); i++) {
            if(regex.charAt(i) == '.') {
                sBuilder.append('.');
            } else {
                sBuilder.append(s.charAt(i));
            }
            rBuilder.append(regex.charAt(i));
        }

        if(sBuilder.toString().length() == s.length() && sBuilder.toString().equals(rBuilder.toString())) {
            return true;
        }

        return false;
    }
}
