import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums == null || nums.length == 0) {
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                ans[0] = map.get(diff);
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return ans;
    }
}
