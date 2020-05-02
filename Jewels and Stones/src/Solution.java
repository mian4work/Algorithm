/*
    You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
    Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

    The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
    so "a" is considered a different type of stone from "A".

    Example 1:

    Input: J = "aA", S = "aAAbbbb"
    Output: 3

    Example 2:

    Input: J = "z", S = "ZZ"
    Output: 0
    Note:

    S and J will consist of letters and have length at most 50.
    The characters in J are distinct.
 */
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * The typical case for using Set
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        if(J.length() == 0 || S.length() == 0) {
            return 0;
        }

        int sum = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }

        for(int i = 0; i < S.length(); i++) {
            if(set.contains(S.charAt(i))) {
                sum++;
            }
        }

        return sum;
    }

    /**
     * A smart solution from leetcode. Here regex [^J] means each any chars NOT in J
     *
     * "[abc]" matches any "a", "b", or "c". "[^ ]" matches characters not in the bracket;
     * e.g. "[^ab]" will match "c" in String "abc". String J was concatenated to "[^" and "]" to
     * create the regex "[^ (all characters in J) ]" in order to replace any characters of S
     * that is not in J with a blank "".
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStonesLeetCode(String J, String S) {
        return S.replaceAll("[^" + J + "]", "").length();
    }
}
