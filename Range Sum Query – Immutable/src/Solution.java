/*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    Example:

    Given nums = [-2, 0, 3, -5, 2, -1]

    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3

    Note:
    You may assume that the array does not change.
    There are many calls to sumRange function.
 */
public class Solution {

    /**
     * Brute force solution: loop through i to j and sum
     * @param nums
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int[] nums, int i, int j) {
        if(j < i || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        for(int index = i; index <= j; index++) {
            sum += nums[index];
        }

        return sum;
    }
}
