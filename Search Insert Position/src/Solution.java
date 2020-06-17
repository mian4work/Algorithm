/*
    Given a sorted array and a target value, return the index if the target is found. If not, return the index
    where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Example 1:

    Input: [1,3,5,6], 5
    Output: 2

    Example 2:

    Input: [1,3,5,6], 2
    Output: 1

    Example 3:

    Input: [1,3,5,6], 7
    Output: 4

    Example 4:

    Input: [1,3,5,6], 0
    Output: 0

 */
public class Solution {
    /**
     * A simple binary search. We need one extra check when target is greater than biggest one in array since we are
     * using low as result. (low can reach maximum to arr.length - 1)
     *
     * Note:
     *      1. use low < high
     *      2. use high = mid if target on left
     *      3. use low = mid + 1 if target on right
     *      4. return low.
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if(nums == null) {
            return 0;
        }

        int low = 0, hi = nums.length - 1;
        if(target > nums[hi]) {
            return hi + 1;
        }
        while(low < hi) {
            int mid = low + (hi - low) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                hi = mid;
            } else if(nums[mid] < target) {
                low = mid + 1;
            }
        }

        return low;
    }
}