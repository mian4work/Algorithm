import java.util.Stack;

/*
    Given a non-negative integer num represented as a string, remove k digits from the number so that the new
    number is the smallest possible.

    Note:
    The length of num is less than 10002 and will be ≥ k.
    The given num does not contain any leading zero.

    Example 1:

    Input: num = "1432219", k = 3
    Output: "1219"
    Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
    Example 2:

    Input: num = "10200", k = 1
    Output: "200"
    Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

    Example 3:

    Input: num = "10", k = 2
    Output: "0"
    Explanation: Remove all the digits from the number and it is left with nothing which is 0.


 */
public class Solution {
    /**
     * By using a stack. We put the element from left to right into the stack. While pushing, we check if the peek()
     * element is greater than the current element. If so, remove the top element and push current one. Each pop()
     * counts as a remove (k--).
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 || k == 0) {
            return num;
        }

        if (num.length() == k) {
            return "0";
        }

        int i = 0;
        Stack<Character> stack = new Stack<>();
        while(i < num.length()) {
            //below use if won't work because "1234567890" with k == 9 will fail. instead, keep pop until num[i] > peek
            while(k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
            i++;
        }

        //this is important because some case like "123", k will never be decreased. in this case
        //remove the rest of k is important. in this case, 3, 2, 1 in stack. if k == 1, remove 3
        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        builder.reverse();
        while(builder.length() > 1 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        return builder.toString();
    }
    /**
     * My first try. Failed.
     *
     * The idea is ok, check i and i + 1 to see which one is greater and remove the greater one.
     *
     * But it missed the edge case like: "112" with 1. My logic will be "12" but the result should be "11"
     *
     * So the solution is to use a stack.
     * @param num
     * @param k
     * @return
     */
    public String removeKdigitsFirstTry(String num, int k) {
        if(num == null || num.length() == 0 || k == 0) {
            return num;
        }

        if(num.length() == k) {
            return "0";
        }

        int i = 0;
        StringBuilder builder = new StringBuilder(num);

        while(i <= k - 1) {
            if(builder.charAt(0) >= builder.charAt(1)) {
                builder.deleteCharAt(0);
            } else {
                builder.deleteCharAt(1);
            }

            i++;
        }

        while(builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        return builder.length() > 0 ? builder.toString() : "0";
    }
}
