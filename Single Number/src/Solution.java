import java.util.HashMap;
import java.util.Map;

/*
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note:

    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:

    Input: [2,2,1]
    Output: 1
    Example 2:

    Input: [4,1,2,1,2]
    Output: 4
 */
public class Solution {

    /**
     * By using a map but is doesn't meet the requirement.
     *
     * @param nums
     * @return
     */
    public int singleNumberMap(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) != null) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for(Integer key : map.keySet()) {
            if(map.get(key) == 1) {
                return key;
            }
        }

        return -1;
    }

    /**
     * Fuck! Using XOR is the best way to go!!!
     *
     * first , we have to know the bitwise XOR in java
     *
     * 0 ^ N = N
     * N ^ N = 0
     * So..... if N is the single number
     *
     * N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
     *
     * = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
     *
     * = 0 ^ 0 ^ ..........^ 0 ^ N
     *
     * = N
     *
     * @param nums
     * @return
     */
    public int singleNumberXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;

        for(int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        return ans;
    }
}
