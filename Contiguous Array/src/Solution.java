import java.util.HashMap;
import java.util.Map;

/*
    Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

    Example 1:
    Input: [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

    Example 2:
    Input: [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

    The first two examples are misleading.

    Example 3:
    Input: [0,0,0,1,1,1,0]
    Output: 6
    Explanation:[0,0,0,1,1,1] is a longest

    Note: The length of the given binary array will not exceed 50,000.
 */
public class Solution {
    /**
     * After another failed try, I found it needs some techniques.
     *
     * Let's first see a sequence:
     *      [ 0,  0, 1,  0,  0,  0, 1, 1 ]   and convert all 0s to -1
     *      [-1, -1, 1, -1, -1, -1, 1, 1 ]   then sum them together
     *      [-1, -2,-1, -2, -3, -4,-3,-2 ]   notice that when same sum appears again, it means the elements in between
     *                                       has the same 1 and 0. For example: -2
     *      [    -2,    -2,          -2 ]    first index is 1, second index is 3, third index is 7
     *                                       So, the first length of equal sub sequence is 3 - 1 = 2 (1, 0)
     *                                       The second length of equal sub sequence is 7 - 1 = 6 (1, 0, 0, 0, 1, 1)
     *
     * Note: don't have to convert 0s to -1 first. I can minus 1 from sum when it is 0 or plus 1 to sum when it is 1.
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int sum = 0, max = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1); //this is quite important. extend nums to -1, 0, 1, 2, ... so the first two elements work
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(indexMap.get(sum) != null) {
                max = Math.max(max, i - indexMap.get(sum));
            } else {
                indexMap.put(sum, i);
            }
        }

        return max;
    }

    /**
     * Failed again.
     * @param nums
     * @return
     */
    public int findMaxLengthFailed(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }

        int max = 0;
        int[] counter = new int[2];
        for(int i = 0; i < nums.length; i++) {
            counter[nums[i]] += 1;
            if(counter[0] == counter[1]) {
                max = Math.max(max, counter[0] + counter[1]);
            }
        }

        if(counter[0] == counter[1]) {
            max = Math.max(max, counter[0] + counter[1]);
        }

        return max;
    }

    /**
     * Still not get the question.
     *
     * I thought the bits are symmetric like [0,0,0,1,1,1] is countable.
     *
     * But [1,0,0,1,1,0] is also countable because the total number of 0 and 1 are the same.
     *
     * Fucked again!!!
     *
     * @param nums
     * @return
     */
    public int findMaxLengthFackedAgain(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }

        int[] counter = new int[2];
        int globalMax = 0;
        int changes = 0; // a counter to remember the changes from 1 to 0 or 0 to 1

        for(int i = 0; i < nums.length - 1; i++) {

            if(changes < 2) {
                if(nums[i] != nums[i + 1]) {
                    changes++;
                    globalMax = Math.max(globalMax, 2); //whenever flips, it counts one length;
                }

                counter[nums[i]] += 1;
            } else {
                if(counter[0] == counter[1]) {
                    globalMax = Math.max(globalMax, counter[0] + counter[1]);
                    counter[0] = 0;
                    counter[1] = 0;
                    changes = 0;
                }
            }
        }

        if(counter[0] == counter[1]) {
            globalMax = Math.max(globalMax, counter[0] + counter[1]);
        }

        return globalMax;
    }

    /**
     * Fucked! I read the question wrong. But it is still a solution for contiguous subarray of two digits.
     *
     * For example 0,1,0,1,0,1 has three contiguous [0,1] so the max length is 6
     *
     * But the question is not this.
     *
     * @param nums
     * @return
     */
    public int findMaxLengthFucked(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }

        //loop each two element from beginning
        //use a pair to record the begining two nums
        //two var start and end hold the value of each two pair.
        int[] pair = new int[2];
        pair[0] = nums[0];
        pair[1] = nums[1];
        int globalSum = 2;
        int localSum = 2;
        for(int i = 3; i < nums.length; i = i + 2) {
            if(pair[0] == nums[i - 1] && pair[1] == nums[i]) {
                localSum += 2;
            } else {
                globalSum = Math.max(globalSum, localSum);
                localSum = 2;
                pair[0] = nums[i - 1];
                pair[1] = nums[i];
            }
        }
        globalSum = Math.max(globalSum, localSum);
        return globalSum;
    }
}
