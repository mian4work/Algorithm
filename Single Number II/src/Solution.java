/*
    Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
    Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:

    Input: [2,2,3,2]
    Output: 3

    Example 2:

    Input: [0,1,0,1,0,1,99]
    Output: 99
 */
public class Solution {
    /**
     * All this single number problem is related with bitwise manipulations.
     *
     * For every element appears two times or odd number of times, just XOR each number and the result is the single one.
     * For every element appears three times, it is different:
     *  Take example: [5,7,5,5], with transfer to bit as follows:
     *      101
     *      111
     *      101
     *      101
     *
     *      1. We know the integer is 32-bit.
     *      2. One EACH bit of all numbers in array "nums", we add them together. For above example, the total on the
     *         least significant bit (LSB 0) is 4, the second is 1 and the most significant bit(MSB 2) is 4
     *      3. How to add each bit? We use >> to move the digit one by one until it is 32. One each move,
     *         we AND with 1 (&) to see if the last digit is a 1 or a 0. For example, 101 & 1 == 1, 10 & 1 == 0.
     *      4. Once we get the sums, we know on each sum, there are multiple 3 SAME digits so we can mod % it with 3.
     *      5. If the mod 3 is not 0, that means on position i, the bit is 1. So we shift back i position and OR (|) with
     *         1 to make result on i position to be 1. result = result | (1 << i)
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int num : nums) {
                //process each number on i's bit.
                count += num >> i & 1;
            }

            //Once we get the count of bit i, we mod 3 to see if it is one
            //If it is, we shift back to position i, and set one by using |
            if(count % 3 == 1) {
                ans |= 1 << i; // ans = ans | i << i
            }
        }

        return ans;
    }
}
