/*
    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class Solution {

    /**
     * Failed this problem. See: https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-53-maximum-subarray/
     *
     * This video explains better: https://www.youtube.com/watch?v=86CQq3pKSUw
     *
     * Example: [1, -3, 2, 1, -1], check the max value of sub-array from 0..i
     *      1. i==0, it is 1
     *      2. i==1, it is the max between max([1, -3], [-3]) which is first: -2
     *      3. i==2, it is the max between max([1, -3, 2], [2]) which is max(sum[i-1] + arr[i], arr[i]): max(-2 + 2, 2) == 2
     *      4. i==3, it is the max between max([1, -3, 2, 1], [i]) which is max(sum[i-1] + arr[i], arr[i]): max(2 + 1, 2) == 3
     *      5. i==4, it is the max between max([1, -3, 2, 1, -1], [-1]) which is max(sum[i-1] + arr[i], arr[i]): max(3 - 1, -1) == 2
     *
     * So, the DP formula is
     *
     *          On given position i, the max value of contiguous subarray is max(max[i-1] + arr[i], arr[i])
     *          The first element i == 0, max[i] = arr[i]
     *
     * We can use an array max[arr.length] to hold the max sum of each index and find the greatest one, which is the result.
     * We can also use an integer to hold the max.
     *
     *
     * @param arr
     * @return
     */
    int maxSubArray(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }

        int max = arr[0], previousMax = 0;

        for(int i = 1; i < arr.length; i++) {
            int temp = previousMax + arr[i];
            if(temp > arr[i]) {
                max = max > temp ? max : temp;
                previousMax = temp;
            } else {
                max = max > arr[i] ? max : arr[i];
                previousMax = arr[i];
            }
        }

        return max;
    }
}
