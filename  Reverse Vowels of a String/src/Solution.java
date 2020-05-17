import java.util.HashSet;
import java.util.Set;
/*
    Write a function that takes a string as input and reverse only the vowels of a string.

    Example 1:

    Input: "hello"
    Output: "holle"
    Example 2:

    Input: "leetcode"
    Output: "leotcede"
    Note:
    The vowels does not include the letter "y".
 */
public class Solution {
    /**
     * A easy one. Using sliding window to solve the problem.
     *
     * The tricky part is change the counter.
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        //create a set to hold vowels
        Set<Character> vow = new HashSet<Character>();
        vow.add('a');
        vow.add('e');
        vow.add('i');
        vow.add('o');
        vow.add('u');
        vow.add('A');
        vow.add('E');
        vow.add('I');
        vow.add('O');
        vow.add('U');

        //using sliding window to find vow
        int start = 0, end = s.length() - 1;
        StringBuilder builder = new StringBuilder(s);
        while(start < end) {
            if(!vow.contains(builder.charAt(start))) {
                start++;
            } else if(!vow.contains(builder.charAt(end))) {
                end--;
            } else {
                if(builder.charAt(start) != builder.charAt(end)) {
                    String c = s.substring(end, end + 1);
                    builder.replace(end, end + 1, s.substring(start, start + 1));
                    builder.replace(start, start + 1,  c);
                }
                //don't forget to change the counter!!!
                start++;
                end--;
            }
        }

        return builder.toString();
    }
}
