import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
    Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list.
    If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction,
    then return null.

    For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox",
    you should return ['the', 'quick', 'brown', 'fox'].

    Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
    return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class Solution {

    /**
     * Parse the string from beginning to the end.
     *
     * This won't work in the case that dict: "bed", "bedbath" and the string is "bedbath"
     *
     * @param dict
     * @param s
     * @return
     */
    public String[] wordBreakForward(Set<String> dict, String s) {
        if(dict == null || dict.size() == 0 || s == null || s.length() == 0) {
            return null;
        }

        List<String> list = new ArrayList<>();
        int pointer = 0;
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(pointer, i);
            if(dict.contains(temp)) {
                list.add(temp);
                pointer = i;
            }
        }

        return list.size() > 0 ? list.toArray(new String[]{}) : null;
    }

    /**
     * Backward loop will solve the problem of dict: "bed", "bedbath" and the string is "bedbath"
     *
     * @param dict
     * @param s
     * @return
     */
    public String[] wordBreakBackward(Set<String> dict, String s) {
        if(dict == null || dict.size() == 0 || s == null || s.length() == 0) {
            return null;
        }

        List<String> list = new ArrayList<>();
        int pointer = s.length() - 1;

        for(int i = pointer; i >= 0; i--) {
            String temp = s.substring(i, pointer + 1);
            if(dict.contains(temp)) {
                list.add(0, temp);
                pointer = i;
            }
        }

        return list.size() > 0 ? list.toArray(new String[]{}) : null;
    }

    /**
     * Use recursion to do the work. Not working. need more work
     *
     * @param dict
     * @param s
     * @return
     */
    public String[] wordBreakRecursion(Set<String> dict, String s) {
        if(dict == null || dict.size() == 0 || s == null || s.length() == 0) {
            return null;
        }

        List<String> list = new ArrayList<>();
        helper(dict, s, list);
        return list.size() > 0 ? list.toArray(new String[]{}) : null;
    }

    private void helper(Set<String> dict, String s, List<String> result) {
        if(s.length() == 0) {
            return;
        }

        if(dict.contains(s)) {
            result.add(0, s);
        }

        helper(dict, s.substring(0, s.length() - 1), result);
    }
}
