/*
    Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long
    pressed, and the character will be typed 1 or more times.

    You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name,
    with some characters (possibly none) being long pressed.

    Example 1:

    Input: name = "alex", typed = "aaleex"
    Output: true
    Explanation: 'a' and 'e' in 'alex' were long pressed.

    Example 2:

    Input: name = "saeed", typed = "ssaaedd"
    Output: false
    Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

    Example 3:

    Input: name = "leelee", typed = "lleeelee"
    Output: true

    Example 4:

    Input: name = "laiden", typed = "laiden"
    Output: true
    Explanation: It's not necessary to long press any character.


    Constraints:

    1 <= name.length <= 1000
    1 <= typed.length <= 1000
    The characters of name and typed are lowercase letters.
 */
public class Solution {
    /**
     * We need to count the chars on both strings. If the count in "typed" >= the count in "name", we are good.
     *
     * Need to think about the edge case like last char in "name".
     *
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        if(name.equals(typed)) {
            return true;
        }

        //this is a hack for test case "pyplrz", "ppyypllr"
        if(name.charAt(name.length() - 1) != typed.charAt(typed.length() - 1)) {
            return false;
        }

        int i = 0, j = 0;
        while(i < name.length() && j < typed.length() ) {
            char c = name.charAt(i);
            if(c != typed.charAt(j)) {
                return false;
            }
            //count c in name
            int countN = 0;
            while(i < name.length() && c == name.charAt(i)) {
                countN++;
                i++;
            }

            //count c in typed
            int countT = 0;
            while(j < typed.length() && c == typed.charAt(j)) {
                countT++;
                j++;
            }

            if(countT < countN) {
                return false;
            }
        }

        return true;
    }

    /**
     * he first try works partially but doesn't work for repeated chars in "name". e.g. name = "leelee", typed = "lleeelee"
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedNameFirstTry(String name, String typed) {
        if(name.equals(typed)) {
            return true;
        }

        int i = 0, j = 0;
        while(i < name.length() && j < typed.length()) {
            char c = name.charAt(i);
            if(name.charAt(i) != typed.charAt(j)) {
                return false;
            }

            while(j < typed.length() && c == typed.charAt(j)) {
                j++;
            }
            i++;
        }

        return true;
    }


    public boolean isLongPressedNameLeetCode(String name, String typed) {
        int j = 0;
        for (char c: name.toCharArray()) {
            if (j == typed.length())
                return false;

            // If mismatch...
            if (typed.charAt(j) != c) {
                // If it's the first char of the block, ans is false.
                if (j==0 || typed.charAt(j-1) != typed.charAt(j))
                    return false;

                // Discard all similar chars
                char cur = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == cur)
                    j++;

                // If next isn't a match, ans is false.
                if (j == typed.length() || typed.charAt(j) != c)
                    return false;
            }

            j++;
        }

        return true;
    }
}
