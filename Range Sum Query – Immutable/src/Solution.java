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
    int[] input;

    public Solution() {}

    /**
     * This problem is not as simple as it shows. The 'There are many calls to sumRange function.' means the function
     * could be called many times. In this case, each call will talk O(n) time to process.
     *
     * So a pre process of the array is important to shorten the query time of function sumRange.
     * Create another array to hold the pre processed data in array input.
     *
     * The pre process is like this:
     *      Each index in array input will hold the sum from 0 to i, assuming input[0] == sum[0].
     *      When we want to retrieve the sum between index i to j:
     *          If i == 0: sum == input[j]
     *          If i > 0 <= j: sum == input[j] - input[i]
     *
     *          Example:    nums:   [1, 2, 3, 4, 5]
     *                      inputs: [1, 3, 6, 10, 15]
     *
     *         Result: i=0, j=3 -> sum = 10
     *                 i=1, j=3 -> sum = 7
     *
     * @param nums
     */
    public Solution(int[] nums) {
        input = new int[nums.length];
        input[0] = nums[0];

        for(int i = 1; i <= nums.length - 1; i++) {
            input[i] = input[i - 1] + nums[i];
        }
    }

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

    /**
     * Use pre processed array input.
     *
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        if(i == 0) {
            return input[j];
        } else {
            return input[j] - input[i - 1]; //Important!!! should be i - 1 because i is included!!!
        }
    }
}
