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

    public String[] wordBreak(Set<String> dict, String s) {
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
}
