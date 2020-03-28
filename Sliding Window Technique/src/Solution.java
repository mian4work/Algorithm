import java.util.*;

/*
    Some examples of sliding window problems

    https://www.youtube.com/watch?v=MK-NZ4hN7rs
 */
public class Solution {

    /**
     * Find the max sum subarray of a fixed size k.
     * This is a fix window problem.
     *
     * Example: [4,2,1,7,8,1,2,8,1,0] and k=3
     * result: 16
     *
     * Loop through the array, we get the sum of the first k.
     * Then subtract the left value which is out of the window and add the right value which is just in the window.
     *
     * @param arr
     * @param k
     * @return
     */
    public int findMaxSumSubarray(int[] arr, int k) {
        int maxValue = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        for(int i = 0; i < arr.length; i++) {
            //first add current value in anyway, later the first one will be removed if necessary.
            currentRunningSum += arr[i];

            if (i >= k - 1) {
                //when i == 2, we first calculate the max
                //then immediately remove the first one on i - (k - 1)
                //so next loop will add the next one just into the window.
                maxValue = Math.max(currentRunningSum, maxValue);
                //i - k + 1 means i - (k - 1)
                currentRunningSum -= arr[i - k + 1];
            }

        }

        return maxValue;
    }

    /**
        Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous
        subarray of which the sum ≥ s. If there isn't one, return 0 instead.

        Example:

        Input: s = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: the subarray [4,3] has the minimal length under the problem constraint.

        Follow up:
        If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
     *
     * @param arr
     * @param k
     * @return
     */
    public int minSubArrayLen(int[] arr, int k) {
        int currentWindowSum = 0;
        int minWindowSize = 0;
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];

            while(currentWindowSum >= k) {
                //moving left pointer to see if it is still >= k
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;
    }

    /**
     * Given an integer k and a string s, find the length of the longest substring that contains
     * at most k distinct characters.
     *
     * For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
     *
     * This took me sometime to figure out how to use Set on edge cases, for example 'ab' k=2
     *
     * The important part is
     *      1. Add the current character at the beginning
     *      2. Calculate the current window length immediately.
     *      3. When check the size of Set, also check if the next string is in the set
     *         because we need to know if we want to keep adding the following char in
     *         for example: bcb since bc is already equals the size so we need to keep moving instead of start++
     *
     * @param s
     * @param k
     * @return
     */
    public String maxDistinctString(String s, int k) {
        if(s == null || k > s.length()) {
            return "";
        }

        int start = 0;
        Set<Character> set = new HashSet<>();
        String currentWindow;
        String maxString = "";


        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            currentWindow = s.substring(start, i + 1);
            maxString = Math.max(maxString.length(), currentWindow.length()) == maxString.length() ?
                    maxString : currentWindow;
            if(set.size() >= k && i < s.length() - 1 && !set.contains(s.charAt(i + 1))) {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return maxString;
    }
}
