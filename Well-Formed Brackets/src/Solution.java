import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/*
    This problem was asked by Facebook.

    Given a string of round, curly, and square open and closing brackets, return whether the brackets
    are balanced (well-formed).

    For example, given the string "([])[]({})", you should return true.

    Given the string "([)]" or "((()", you should return false.
 */
public class Solution {

    /**
     * Use a stack to push the opening bracket and pop when meet the closing one to compare.
     * Check if the length of the string is even number. Otherwise, return false immediately.
     *
     * Note: Check if the stack is empty at the end to make sure the brackets numbers match.
     *
     * @param s
     * @return
     */
    public boolean wellFormed(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }

        Set<Character> start = new HashSet<>();
        start.add('(');
        start.add('[');
        start.add('{');

        Set<Character> end = new HashSet<>();
        end.add(')');
        end.add(']');
        end.add('}');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(start.contains(c)) {
                stack.push(c);
            } else if(!end.contains(c)) {
                return false;
            } else {
                if(stack.empty() || !match(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    boolean match(Character a, Character b) {
        switch (a) {
            case '(': return b == ')';
            case '{': return b == '}';
            case '[': return b == ']';
            default: return false;
        }
    }

    /**
     * I read the question wrong!
     * @param s
     * @return
     */
    public boolean wellFormedWrong(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }

        int rStart = 0, rEnd = 0;
        int sStart = 0, sEnd = 0;
        int cStrt = 0, cEnd = 0;

        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(': rStart++; break;
                case ')': rEnd++; break;
                case '[': sStart++; break;
                case ']': sEnd++; break;
                case '{': cStrt++; break;
                case '}': cEnd++;
            }
        }

        return rStart == rEnd && sStart == sEnd && cStrt == cEnd;
    }
}
