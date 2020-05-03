import java.util.HashMap;
import java.util.Map;

/*
    Given an arbitrary ransom note string and another string containing letters from all the magazines,
    write a function that will return true if the ransom note can be constructed from the magazines ;
    otherwise, it will return false.

    Each letter in the magazine string can only be used once in your ransom note.

    Note:
    You may assume that both strings contain only lowercase letters.

    canConstruct("a", "b") -> false
    canConstruct("aa", "ab") -> false
    canConstruct("aa", "aab") -> true
 */
public class Solution {
    /**
     * Pretty straight forward solution:
     *      Use a map to count how many each char in magazine.
     *      Check char in ransomNote one by one:
     *          if it doesn't exist, return false
     *          if the count of it is 0, return false
     *          if the count of it > 0, reduce the count by 1 and continue.
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null) {
            return false;
        }
        Map<Character, Integer> dic = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            dic.put(c, dic.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            if(!dic.containsKey(c) || dic.get(c) == 0) {
                return false;
            } else {
                dic.put(c, dic.get(c) - 1);
            }
        }

        return true;
    }

    /**
     * A smart way to do the work by manipulating string chars.
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstructLeetCode(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }

        for(int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
    /**
     * First try. Misunderstand the problem. I thought the ransomNote needs to be a substring in magazine.
     *
     * But the solution to it needs to be remembered.
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
     public boolean canConstructFailed(String ransomNote, String magazine) {
         int n = ransomNote.length();
         int m = magazine.length();
         for(int i = 0; m - i >= n; i++) {
             String sub = magazine.substring(i, i + n);
             if(ransomNote.equals(sub)) {
                 return true;
             }
         }

         return false;
     }
}
