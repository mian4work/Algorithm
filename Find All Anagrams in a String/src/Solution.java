import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger
    than 20,100.

    The order of output does not matter.

    Example 1:

    Input:
    s: "cbaebabacd" p: "abc"

    Output:
    [0, 6]

    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".

    Example 2:

    Input:
    s: "abab" p: "ab"

    Output:
    [0, 1, 2]

    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class Solution {
    /**
     * A easy to understand solution but not very efficient.
     *
     * https://www.youtube.com/watch?v=-rcfE1Tj2E0
     *
     * It is similar to problem: Permutation of String.
     * 
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) {
            return list;
        }

        //use 26 letters array to record the string p (instead of adding up)
        int[] cs = new int[26];
        int[] cp = new int[26];

        for(int i = 0; i < s.length(); i++) {
            cs[s.charAt(i) - 'a']++;
            if(i < p.length()) {
                cp[p.charAt(i) - 'a']++;
            }
        }

        int start = 0, end = 0;
        while(end < p.length()) {
            cs[s.charAt(end) - 'a']--;
            cp[s.charAt(end) - 'a']--;
            end++;
        }

        if(equals(cp, cs)) {
            list.add(start);
        }

        while(end < s.length()) {
            //process start
            cs[s.charAt(start) - 'a']++;
            cp[s.charAt(start) - 'a']++;
            start++;

            cs[s.charAt(end) - 'a']--;
            cp[s.charAt(end) - 'a']--;
            end++;

            if(equals(cp, cs)) {
                list.add(start);
            }
        }

        return list;
    }

    boolean equals(int[] chars1, int[] chars2) {
        for(int i = 0; i < chars1.length; i++) {
            if(chars1[i] != 0 && chars2[i] != chars1[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Second try by using sliding window. Failed again. Need to think in advance carefully before implementation.
     *
     * The idea is to add up each (char-'a') of string p and using sliding window tech on string s.
     *
     * But the add up won't work on case like "aa", you can't distinguish "aa", "a" or "aaaa"
     *
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsSecondTry(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length()) {
            return list;
        }

        int pSum = p.charAt(0) - 'a', sSum = 0, start = 0, end = 0;
        for(int i = 1; i < p.length(); i++) {
            pSum += valueOf(p.charAt(i));
        }
        while(end < p.length()) {
            sSum += valueOf(s.charAt(end));
            end++;
        }

        if(pSum == sSum) {
            list.add(start);
        }
        //moving sliding window. remove start value from sSum and add end value into sSum
        while(end < s.length() - 1) {
            sSum -= valueOf(s.charAt(start));
            sSum += valueOf(s.charAt(end));
            start++;
            end++;

            if(sSum == pSum) {
                list.add(start);
            }
        }
        return list;
    }

    int valueOf(char c) {
        return c - 'a';
    }
    /**
     * First try failed. Time exceed limit. Also, it is too complicated to finish in 40 minutes without debugging.
     *
     * Need to think carefully before using brute force.
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagramsFirstTry(String s, String p) {
        //brute force
        int n = p.length();
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        Map<Character, Integer> tmap = new HashMap<>();
        tmap.putAll(map);
        for (int i = 0; i <= s.length() - n; i++) {
            if (tmap.keySet().contains(s.charAt(i))) {
                int j = i;
                list.add(i);
                while (j < i + n) {
                    Character c = s.charAt(j);
                    if (tmap.keySet().contains(c)) {
                        if (tmap.get(c) > 0) {
                            tmap.put(c, tmap.get(c) - 1);
                            if(tmap.get(c) == 0) {
                                tmap.remove(c);
                            }
                        }
                    } else {
                        list.remove(list.size() - 1);
                        break;
                    }
                    j++;
                }
                tmap.putAll(map);
            }
        }

        return list;
    }
}
