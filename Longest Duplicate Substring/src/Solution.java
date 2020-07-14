import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
    (The occurrences may overlap.)

    Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring,
    the answer is "".)



    Example 1:

    Input: "banana"
    Output: "ana"

    Example 2:

    Input: "abcd"
    Output: ""


    Note:

    2 <= S.length <= 10^5
    S consists of lowercase English letters.
 */
public class Solution {
    public String longestDupSubstring(String S) {
        if(S == null || S.length() == 0) {
            return S;
        }

        String max = "";
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < S.length(); i++) {
            if(map.containsKey(S.charAt(i))) {
                int start = map.get(S.charAt(i));
                String len = compare(S, start, i);
                max = max.length() > len.length() ? max : len;
            }

            map.put(S.charAt(i), i);
        }

        return max;
    }

    String compare(String S, int start, int end) {
        StringBuilder builder = new StringBuilder();
        while(end < S.length()) {
            if(S.charAt(start) == S.charAt(end)) {
                builder.append(S.charAt(start));
            } else {
                break;
            }
            start++;
            end++;
        }

        return builder.toString();
    }
}
