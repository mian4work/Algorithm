import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array of size n, find the majority element. The majority element is the element that appears
    more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.

    Example 1:

    Input: [3,2,3]
    Output: 3
    Example 2:

    Input: [2,2,1,1,1,2,2]
    Output: 2
 */
public class Solution {
    /**
     * The solution is simple. Use a map to count. There may be better way to solve the problem.
     *
     * The result is 64%
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for(Integer key : map.keySet()) {
            if(map.get(key) > count) {
                return key;
            }
        }

        return -1;
    }

    /**
     * Sort and get the element at len/2!!!
     *
     * Damn!
     * @param nums
     * @return
     */
    public int majorityElementLeetCode(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
