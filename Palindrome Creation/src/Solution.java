/*
    This problem was asked by Quora.

    Given a string, find the palindrome that can be made by inserting the fewest number of characters as possible
    anywhere in the word. If there is more than one palindrome of minimum length that can be made, return the
    lexicographically earliest one (the first one alphabetically).

    For example, given the string "race", you should return "ecarace", since we can add three letters
    to it (which is the smallest amount to make a palindrome).
    There are seven other palindromes that can be made from "race" by adding three letters,
    but "ecarace" comes first alphabetically.

    As another example, given the string "google", you should return "elgoogle".
 */
public class Solution {
    public String palindromeRecursion(String s) {

        if(s.equals(new StringBuilder(s).reverse().toString())) {
            return s;
        }

        String first = s.substring(0, 1);
        String last = s.substring(s.length() - 1);

        if(first.equals(last)) {
            return first + palindromeRecursion(s.substring(1, s.length() - 1)) + first;
        } else {
            String one = first + palindromeRecursion(s.substring(1, s.length())) + first;
            String two = last + palindromeRecursion(s.substring(0, s.length() - 1)) + last;

            if(one.length() > two.length()) {
                return one;
            } else if(one.length() < two.length()) {
                return two;
            } else {
                if(one.charAt(0) > two.charAt(0)) {
                    return two;
                } else {
                    return one;
                }
            }
        }
    }
}
