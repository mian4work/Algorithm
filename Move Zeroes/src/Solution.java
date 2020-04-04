/*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative
    order of the non-zero elements.

    Example:

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Note:
    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
 */
public class Solution {
    /**
     * The solution is
     *      1. check nums[i] == 0 ? if yes, increase the zero window
     *      2. if not
     *          check nums[i - 1] == 0? if no, do nothing
     *          if yes: swap nums[i] with the first element in the zero window.
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int w = 0; //the zero window with w number of zeros
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) { //increase the zero window
                w++;
            } else if(i > 0 && nums[i - 1] == 0) {
                int temp = nums[i - w];
                nums[i - w] = nums[i];
                nums[i] = temp;
            }
        }
    }

    /**
     * A interesting solution. Although it is not efficient than mine but easy to understand.
     *
     * The idea is to shift all non-zero elements to the front.
     * Then fill all zeros to the end.
     *
     * @param nums
     */
    public void moveZeroesInsert(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
