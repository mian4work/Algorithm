import java.util.*;

/*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
    determine if s can be segmented into a space-separated sequence of one or more dictionary words.
    You may assume the dictionary does not contain duplicate words.

    For example, given
    s = "leetcode",
    dict = ["leet", "code"].

    Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution {

    /**
     * Brute force. Failed.
     *
     * Using two pointer start and end to get the sub-string in the String s.
     *
     * Moving end from (start + 1) and check the sub-String is in dic:
     *      if not, index++
     *      if yes, mark to true. then set start = end and end = start + 1.
     *      til end reaches to end, combine the final result.
     *
     * String.subString(start, end) where end char is excluded!
     *
     * Has bug in this solution. It can't pass 'aaaaaaa' and ['aaaa', 'aaa'] because it calculate the first 'aaa' and
     * second 'aaa' then the last 'a' is false.
     *
     * @param s
     * @param dic
     * @return
     */
    public boolean wordBreakBruteForce(String s, List<String> dic) {
        if(s == null || s.length() == 0 || dic.size() == 0) {
            return false;
        }

        int start = 0, end = 1;
        boolean result = false;

        while(start < s.length()) {
            if(dic.contains(s.substring(start, end))) {
                result = true;
                start = end;
                end = start + 1;
            } else {
                end++;
                if(end >= s.length()) {
                    //if end is out of boundary, just use start to get the rest of string.
                    result = result && dic.contains(s.substring(start));
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Really a smart solution.
     *
     * Use a queue to save the string (or sub string) which is to be processed or to be chopped.
     * Use a set to save the visited string.
     *
     * Loop the string s. Chop string based on current index i.
     *      if the first part chopped is in dic, and the second part leftOver is not in visited
     *          (because if the leftOver is visited, that means these two parts are all in dic,
     *          just wait for next loop to pop up it and return true.)
     *          push leftOver to the queue and add dic into visited set.
     *      else
     *          continue to process the string in the queue.
     *
     *
     * @param s
     * @param dic
     * @return
     */
    public boolean wordBreakQueue(String s, List<String> dic) {
        if(s == null || s.length() == 0 || dic.size() == 0) {
            return false;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);

        while(!queue.isEmpty()) {
            String toBeProcessed = queue.poll();
            if(dic.contains(toBeProcessed)) {
                return true;
            }

            for(int i = 0; i < toBeProcessed.length(); i++) {
                String chopped = toBeProcessed.substring(0, i);
                String leftOver = toBeProcessed.substring(i);

                if(!visited.contains(leftOver) && dic.contains(chopped)) {
                    queue.offer(leftOver);
                    visited.add(chopped);
                }
            }
        }

        return false;
    }

    /**
     * Use Depth First Search
     *
     * Don't fully understand yet.
     *
     * @param s
     * @param dic
     * @return
     */
    public boolean wordBreakDFS(String s, List<String> dic) {
        if(s == null || s.length() == 0 || dic.size() == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        return wordBreakDFS(s, 0, set, dic);
    }

    private boolean wordBreakDFS(String s, int start, Set<Integer> set, List<String> dic) {
        if(start == s.length()) {
            return true; //why?
         }

        for(int i = start + 1; i <= s.length(); i++) {
            if(set.contains(i)){
                continue;
            }

            String temp = s.substring(start, i);
            if(dic.contains(s.substring(start, i))) {
                if(wordBreakDFS(s, i, set, dic)){
                    return true;
                }

                set.add(i);
            }
        }

        return false;
    }

    /**
     * Use Dynamic Programming.
     *
     * The key is to create a boolean array 'breakable'(s.length + 1 length). At each element i, the value is whether
     * s[0..i-1] is breakable (means if it is in the dic). If it is, set breakable[i] to true, otherwise, false.
     *
     * The final result is the last element in breakable array.
     *
     * Example: dict = ["leet", "code"].
     *
     *     s:               l   e   e   t   c   o   d   e
     *     breakable:       t   f   f   f   t   f   f   f   t
     *
     * Step by step:
     *
     * |T| | | | | | | | |
     *  0 1 2 3 4 5 6 7 8
     *
     * i = 1
     * j = o sub = l
     *
     * i = 2
     * j = 0 sub = le
     * j = 1 sub = e
     *
     * i = 3
     * j = 0 sub = lee
     * j = 1 sub = ee
     * j = 2 sub = e
     *
     * i = 4
     * j = 0 sub = leet && T[0] and then break, no need to check for rest
     * |T| | | |T| | | | |
     *  0 1 2 3 4 5 6 7 8
     *
     * i = 5
     * j = 0 sub = leetc
     * j = 1 sub = eetc
     * j = 2 sub = etc
     * j = 3 sub = tc
     * j = 4 sub = c
     *
     * i = 6
     * j = 0 sub = leetco
     * j = 1 sub = eetco
     * j = 2 sub = etco
     * j = 3 sub = tco
     * j = 4 sub = co
     * j = 5 sub = o
     *
     * i = 7
     * j = 0 sub = leetcod
     * j = 1 sub = eetcod
     * j = 2 sub = etcod
     * j = 3 sub = tcod
     * j = 4 sub = cod
     * j = 5 sub = od
     * j = 6 sub = d
     *
     * i = 8
     * j = 0 sub = leetcode
     * j = 1 sub = eetcode
     * j = 2 sub = etcode
     * j = 3 sub = tcode
     * j = 4 sub = code && T[4] and then break
     *
     * |T| | | |T| | | |T|
     *  0 1 2 3 4 5 6 7 8
     *
     *
     * @param s
     * @param dic
     * @return
     */
    public boolean wordBreakDP(String s, List<String> dic) {
        if(s == null || s.length() == 0 || dic.size() == 0) {
            return false;
        }

        boolean[] breakable = new boolean[s.length() + 1];
        //Set the first element to true. Each breakable[i] is the result of s[0..i-1]
        // This is necessary because the starting point is true. Otherwise if it && with other, the result will always to be false.
        breakable[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(breakable[j] && dic.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }

        return breakable[s.length()];
    }
}
