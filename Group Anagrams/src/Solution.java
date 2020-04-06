import java.util.*;

/*
    Given an array of strings, group anagrams together.

    Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
 */
public class Solution {
    /**
     * This works but exceeds the time limits.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsMind(String[] strs) {

        //data structure:
        //using set to check if it is anagrams
        //using list of list to hold the result

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(strs[0]);
        ans.add(list);

        for(int i = 1; i< strs.length; i++) {
            boolean added = false;
            loop:
            for(int j = 0; j < ans.size(); j++) {
                if(isAnagrams(ans.get(j).get(0), strs[i])) {
                    ans.get(j).add(strs[i]);
                    added = true;
                    break loop;
                }
            }

            if(!added) {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                ans.add(newList);
            }
        }

        return ans;
    }

    boolean isAnagrams(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();

        for(int i = 0; i < a.length(); i++) {
            String x = a.substring(i, i+1);
            String y = b.substring(i, i+1);
            if (mapA.get(x) == null) {
                mapA.put(x, 1);
            } else {
                mapA.put(x, mapA.get(x) + 1);
            }

            if (mapB.get(y) == null) {
                mapB.put(y, 1);
            } else {
                mapB.put(y, mapB.get(y) + 1);
            }
        }

        if(mapA.size() != mapB.size()) {
            return false;
        }

        for(int i = 0; i < a.length(); i++) {
            String x = a.substring(i, i+1);
            if(mapA.get(x) != mapB.get(x)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Sort each string and use sorted string as key to store a list of anagrams.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) {
            return null;
        }

        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if(map.get(key) == null) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * The count sort. Not working yet.
     * @param s
     * @return
     */
    public String sort(String s) {
        int[] chars = new int[26];

        for(char c : s.toCharArray()) {
            int index = c - 'a';
            chars[index] += 1;
        }

        for(int i = 1; i < chars.length; i++) {
            chars[i] = chars[i] + chars[i - 1];
        }

        char[] position = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            position[chars[index]] = s.charAt(i);
            position[chars[index]] -= 1;
        }

        return new String(position);
    }
}
