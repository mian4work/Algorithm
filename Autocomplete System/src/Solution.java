/*
    Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
    return all strings in the set that have s as a prefix.

    For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

    Hint: Try pre-processing the dictionary into a more efficient data structure to speed up queries.
 */

import java.util.*;

public class Solution {
    private Map<String, List<String>> dictionary = new HashMap<>();

    /**
     * Transfer the string array to a key=String, value=List Map. Process all strings in the list one by one from first char to the last one.
     * For example:
     *
     * d -> [dog, deer, deal]
     * de -> [deer, deal]
     * do -> [dog]
     * dea -> [deal]
     * etc.
     *
     * @param dic
     */
    public Solution(String[] dic) {
        if(dic != null && dic.length != 0) {
            for(int i = 0; i < dic.length; i++) {
                String curr = dic[i];
                for(int j = 1; j <= curr.length(); j++) {
                    String prefix = curr.substring(0, j).toLowerCase(); //improve the space.
                    List<String> stringList = dictionary.get(prefix) == null ? new ArrayList<>() : dictionary.get(prefix);
                    stringList.add(curr);
                    dictionary.put(prefix, stringList);
                }
            }
        }
    }

    public String[] search(String s) {
        List<String> list = dictionary.get(s.toLowerCase());

        return list == null ? new String[]{} : list.toArray(new String[0]);
    }
}
