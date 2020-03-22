import java.util.ArrayList;
import java.util.List;

/*
    Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

    For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
 */
public class Solution {

    /**
     * Brute force solution. Maintain a list of chars while looping through the String array. At each element, loop it
     * from the next element:
     *      if list has this element, continue
     *      if list does not exceed the size k, which means still has space, add this element in
     *      if list exceeds the size k, grab the string and check if it is the longest.
     *
     * This solution has a bug, can't do [ab] with size 2. Will fix it later.
     *
     * @param s
     * @param k
     * @return
     */
    public String maxDistinctString(String s, int k) {
        if(s == null || s.length() == 0 || k == 0) {
            return "";
        }

        String max = "";
        String[] arr = s.split("");

        for(int i = 0; i < arr.length - 1; i++) {
            List<String> keys = new ArrayList<>();
            keys.add(arr[i]);
            loop:
            for (int j = i + 1; j < arr.length; j++) {
                String current = arr[j];
                if(keys.contains(current)) {
                    continue;
                } else if(keys.size() < k) {
                    keys.add(current);
                } else {
                    String p = s.substring(i, j);
                    max = p.length() > max.length() ? p : max;
                    break loop;
                }
            }
        }

        return max;
    }
}
