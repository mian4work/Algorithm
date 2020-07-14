import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers and an integer k, you need to find the total number of continuous sub arrays
    whose sum equals to k.

    Example 1:
    Input:nums = [1,1,1], k = 2
    Output: 2

    Note:
    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class LeetCode {
    /**
     * Started from floating window but failed because the nums and k may be negative. Floating window only solves the
     * positive element problem!!!
     *
     * The solution relies on the fact that diff between i, j is sum[j] - sum[i]:
     *      1. calculate the sum along the way: sum += nums[i]
     *      2. save each sum[i]
     *      3. at element j:
     *          if sum[j] - k == (saved sum), we know there is one continuous sub array(i,j) which sum to k
     *      4. but how do we know how many sub arrays which sum to k?
     *          use a hashmap which:
     *              key is sum for each element
     *              value is how many times it occurs. since the element may be negative, so the sum of elements may
     *              occur more than one. if it shows twice and sum[x] - k = sum, it means there are two sub arrays which
     *              sum to k.
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int total = 0, sum = 0;
        //key: sum so far. value: how many times it occurs.
        Map<Integer, Integer> map = new HashMap<>();
        //need a starting point
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                total += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return total;
    }
}
