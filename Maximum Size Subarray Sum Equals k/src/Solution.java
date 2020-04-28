import java.util.HashMap;
import java.util.Map;

/*
    Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
    If there isn't one, return 0 instead.

    Example:
    Input: nums = [1,1,1], k = 2
    Output: 2
 */
public class Solution {
    /**
     * Create a prefix sum array "prefixSum", in which each element i's value is the sum of i - 1.
     *
     * The key point is between any two index: i and j,
     *      the diff is prefixSum[j] - prefixSum[i].
     *      if diff == k, then j - i is the size of sub array.
     *
     * But how can we remember i?
     *      we use a "sum to index map" sumIndexMap:
     *          key is the sum to i
     *          value is the index i
     *
     *      when loop to index j
     *          do k - prefixSum[j], which is k minus the "sum to j". we get a diff
     *          since each key: sum and value: index is saved in map: sumIndexMap, we use diff to check if it exists
     *          if exists, let's say it is the sum to index i, we use j - i get the size because
     *          prefixSum[j] - prefixSum[i] == k (means prefixSum[j] - k == diff == prefixSum[i])
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumPrefixSum(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        int max = 0;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        for(int i = 0; i < prefixSum.length; i++) {

            int diff = prefixSum[i] - k;
            if(sumIndexMap.containsKey(diff)) {
                max = Math.max(max, i - sumIndexMap.get(diff));
            }

            sumIndexMap.put(prefixSum[i], i);
        }

        return max;
    }

    /**
     * Same idea with above solution but we don't use prefixSum array to record the sum to index
     *
     * Just keep adding and save to "sum to index map". At each index j, check the k - jsum is in map or not
     *      if yes, retrieve saved index i
     *      otherwise, save jsum into map key: jsum and value j
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumPrefixSumNoArray(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        int max = 0, sum = nums[0];
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(sum, 0);

        for(int i = 1; i < nums.length; i++) {
            sum += nums[i];
            int diff = sum - k;
            if(sumIndexMap.containsKey(diff)) {
                max = Math.max(max, i - sumIndexMap.get(diff));
            }

            sumIndexMap.put(nums[i], i);
        }

        return max;
    }

    /**
     * Use two pointers left and right to record the position.
     *
     * sum from 0 by using right pointer.
     *      if value between left and right is k, record the size.
     *      if value between left and right is less than k, keep adding right value
     *      if value between left and right is more than k, move left to right and remove value at left one by one
     *      until it either equals to k (then record) or remember the left and keeps moving right.
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumTwoPointer(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        int max = 0, sum = 0, left = 0, right = 0;
        for(right = 0; right < nums.length; right++) {
            sum += nums[right];
            if(sum == k) {
                max = Math.max(max, right - left);
            } else if(sum > k) {
                while(left < right) {
                    int value = nums[left++];
                    sum -= value;
                    if(sum == k) {
                        max = Math.max(max, right - left);
                    } else if (sum < k) {
                        break;
                    }
                }
            }
        }
        return max;
    }

    /**
     * Brute force. Try adding each element i with rest of the element to see if the sum is k.
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySumGreedy(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) {
            return 0;
        }

        int max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    max = Math.max(max, j - i);
                }
            }
        }

        return max;
    }
}
