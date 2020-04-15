/*
    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
    of all the elements of nums except nums[i].

    Example:
    Input:  [1,2,3,4]
    Output: [24,12,8,6]

    Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array
    (including the whole array) fits in a 32 bit integer.

    Note: Please solve it without division and in O(n).

    Follow up:
    Could you solve it with constant space complexity? (The output array does not count as extra space for the
    purpose of space complexity analysis.)
 */
public class Solution {
    /**
     * Since the division is not allowed, we have to use two arrays, at each element i:
     *      left array: save the product from left (0) to i (not include i)
     *      right array: save the product from right (len - 1) to i (not include i)
     *      multiple each element in left and right arrays
     *      we got the result.
     *
     *      Time complexity is O(n) and Space complexity is O9n)
     *
     * But we can optimize the space complexity by using the output array ans[]
     *      treat ans[] as left array. do same with left array above.
     *
     *      loop from right to left:
     *          set right product to 1 at beginning and multiple with ans[i] (which is left product)
     *          save to ans[i].
     *          then multiple right product with nums[i]
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int[] ans = new int[nums.length];

        //calculate the left product to i(not include i) and save in ans
        ans[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        //cacluate the right product to i(not include i) from right to left
        //and directly multiple with right then save to ans
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }

        return ans;
    }
}
