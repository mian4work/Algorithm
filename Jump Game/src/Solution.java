/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.

    Example 1:

    Input: [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:

    Input: [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum
                 jump length is 0, which makes it impossible to reach the last index.
 */
public class Solution {
    /**
     * The third try passed 98.65%
     *
     * The zero index needs to be changing. If we can't jump over the first zero, there is no way to jump over last zero.
     *
     * The solution is to loop backward. When encounter a zero (which is initialized as -1)
     *      1. remember its index
     *      2. keep looping back and check if there is any element which can jump over (value > distance from index)
     *      3. if it can jump over, reset the index to -1
     *      4. keep looping back to see if there is other zeros. if so, repeat above steps.
     *      5. finally check if the index is -1 or not.
     *          if it is -1, that means
     *              either there is no zero or all zeros can be jump over
     *          if it is not, that means
     *              either we can't jump some zeros or the first index is zero.
     *
     * @see <a href="https://leetcode.com/problems/jump-game/solution/">LeetCode explanation</a>
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int zero = -1; //index when nums[i] == 0
        for(int i = nums.length - 2; i >= 0; i--) {
            if(zero < 0 && nums[i] == 0) {
                zero = i;
            } else {
                if (zero > 0) {
                    int distance = zero - i;
                    if (nums[i] > distance) {
                        zero = -1;
                    }
                }
            }
        }

        return zero < 0 ? true : false;
    }
    /**
     * Second try also has some problems.
     *
     * [1,0,0,1,1,2,2,0,2,2] wont work.
     *
     *
     * Looks like the last zero is the key. If it can be jumped over, the result is true.
     * @param nums
     * @return
     */
    public boolean canJumpSecondTry(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int last = -1; //the index of last zero
        for(int i = nums.length - 2; i >= 0; i--) {
            //find the last zero
            if(nums[i] == 0) {
                last = i;
                break;
            }
        }

        //if there is no zero in nums, it is always true because we can use 1 step to go through.
        if(last < 0) {
            return true;
        } else if (last == 0) {
            return false;
        }

        for(int i = 0; i < last; i++) {
            int distance = last - i;
            if(nums[i] > distance) {
                return true;
            }
        }

        return false;
    }
    /**
     * First try. Have some problems
     * My thought is loop back from end. Check if nums[i] is zero. If so, count the zero. When move
     * to the first un-zero number, check if it is greater than the zero count. If yes, it is true
     * and keep moving. If not, return false directly since it can never jump over these zeros.
     */
    public boolean canJumpFirstTry(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }

        int zeros = 0; //use to count how many zeros
        for(int i = nums.length - 1; i >= 0; i--) {
            int value = nums[i];
            if(value == 0) {
                zeros++;
            } else if(value != 0) {
                if(value < zeros) {
                    return false;
                } else {
                    zeros = 0; //reset zero counter
                }
            }
        }

        return zeros == 0 ? true : false; //check if the first element is zero.
    }
}
