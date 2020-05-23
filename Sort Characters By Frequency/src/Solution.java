import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
    Given a string, sort it in decreasing order based on the frequency of characters.

    Example 1:

    Input:
    "tree"

    Output:
    "eert"

    Explanation:
    'e' appears twice while 'r' and 't' both appear once.
    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

    Example 2:

    Input:
    "cccaaa"

    Output:
    "cccaaa"

    Explanation:
    Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
    Note that "cacaca" is incorrect, as the same characters must be together.

    Example 3:

    Input:
    "Aabb"

    Output:
    "bbAa"

    Explanation:
    "bbaA" is also a valid answer, but "Aabb" is incorrect.
    Note that 'A' and 'a' are treated as two different characters.
 */
public class Solution {
    /**
     * The important part of this solution is how to use data structure.
     *
     * PriorityQueue is easy to understand but it is hard to know that I can use Map.Entry (Map contains a collection
     * of Entry).
     *
     * Solution:
     *      1. Use a char to int Map to count the char frequency
     *      2. Put every entry of map to a PriorityQueue with count from high to low
     *      3. Poll entry one by one and loop to add char by count times.
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        queue.addAll(map.entrySet());

        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            int count = entry.getValue();
            while(count > 0) {
                builder.append(entry.getKey());
                count--;
            }
        }

        return builder.toString();
    }

    /**
     * This is not being used but it is a good example of BiMap
     */
    class BiMap {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> inverseMap = new HashMap<>();

        public void put(Integer key) {
            Integer v = map.getOrDefault(key, 0) + 1;
            map.put(key, v);
            inverseMap.put(v, key);
        }

        public Integer get(Integer key) {
            return map.get(key);
        }

        public Integer getKey(Integer val) {
            return inverseMap.get(val);
        }
    }
    /**
     * My first try. Wrong, not because of algorithm but because of my misunderstanding the question.
     * The question is asked for frequency but I thought it asks for contingent same chars. The first one
     * is even simpler.
     *
     * Thought:
     *      1. using sliding window to get repeated sub string
     *      2. use a priority queue to save the map (len -> list of starting index)
     *      3. use string builder to rebuild the new string
     * @param s
     * @return
     */
    public String frequencySortFirstTry(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }


        //the int[] contains only two element: index and length
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        //sliding window
        int start = 0, end = 0;
        while(end < s.length() - 1) {
            int len = 1;
            start = end;
            while(end < s.length() - 1 && s.charAt(end) == s.charAt(end + 1)) {
                len++;
                end++;
            }
            end++;
            if(len > 1) {
                //save the len and start index
                queue.add(new int[]{start, len});
                start = end;
            }
        }

        StringBuilder builder = new StringBuilder();
        StringBuilder rest = new StringBuilder(s);
        for(int i = 0; i < queue.size(); i++) {
            int[] e = queue.poll();
            builder.append(rest.subSequence(e[0], e[0] + e[1]));
            rest.replace(e[0], e[0] + e[1], "");
        }

        builder.append(rest.toString());
        return builder.toString();
    }
}
