public class Solution {
    /**
     * It looks easy but actually not.
     *
     * The best diagram is https://assets.leetcode.com/users/hiepit/image_1587057639.png
     *
     * Count how many parentheses. When '(', ++, when ')', --. But when '*', it can be '(', ')' or empty.
     * So, max will ++ for '(' and min will -- for ')'. Nothing happens when it is empty.
     *
     * When max < 0, return false because it means the open parentheses is not enough. It is invalid. Example: (()))
     * At the same time, min < 0 (since open parentheses is not enough) so we make it 0 and start over again.
     *
     * Finally, we check if min == 0 which is balanced.
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        int max = 0, min = 0; //count how many parentheses
        for(Character c : s.toCharArray()) {
            if(c == '(') {
                max++;
                min++;
            } else if(c == ')') {
                max--;
                min--;
            } else if(c == '*') {
                max++; //   means * is (
                min--; //   means * is )
                // do nothing * is empty
            }

            if(max < 0) {
                return false; //means open parentheses is not enough
            }
            min = Math.max(min, 0); //make sure min is not negative.
        }

        return min == 0;
    }

    /**
     * Another interesting solution:
     *
     * Use two loops:
     *      first loop 0..len - 1: replace all '*' to '(' and calculate the balance. If sum < 0, it means no enough '(' to balance
     *      return false.
     *
     *      second loop len-1..0: replace all '*' to ')' and calculate the balance. If sum < 0, it means no enough ')' to balance
     *      return false.
     *
     *      otherwise, it is balanced. the extra '*' can be treated as empty
     *
     * Smart!
     *
     * @param s
     * @return
     */
    public boolean checkValidStringReplace(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }

        int leftBalance = 0, rightBalance = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '*') {
                leftBalance++;
            } else {
                leftBalance--;
            }

            if(leftBalance < 0) {
                return false; //any time when left balance is negative, return false. example: )()
            }
        }

        if(leftBalance == 0) {
            return true; //this is possible when no parenthesis but balanced left and right.
        }

        for (int i = s.length() - 1; i >= 0; i++) {
            if(s.charAt(i) == ')' || s.charAt(i) == '*') {
                rightBalance++;
            } else {
                rightBalance--;
            }
        }

        if(rightBalance < 0) {
            return false; //any time when right balance from n-1..0 is negative, return false. example: ()(
        }

        return true;
    }
}
