/*
    See the diagram: https://leetcode.com/problems/trapping-rain-water/

    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

    The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */
public class Solution {

    /**
     * My solution failed. I only think about from left to right.
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }

        int result = 0, temp = 0, start = 0, end = 0;

        while(start < height.length - 1) {
            end = start + 1;

            while(end <= height.length - 1 && height[start] > height[end]) {
                temp += height[start] - height[end];
                end++;
            }

            if(end < height.length - 1) {
                result += temp;
            }

            temp = 0;
            start = end;
        }

        return result;
    }

    /**
     * Think about any bar, let's say bar i.
     *
     * 1. Try to find the highest bar on left side of i: max(height[0], height[i-1])
     * 2. Try to find the highest bar on right side of i: max(height[i+1], height[n-1])
     * 3. Compare left highest and right highest bars and find the small one (because you can only hold water by smaller bar): min(max_left, max_right)
     * 4. The amount of water on bar i can hold is the min_highest_bar - height_of_bar_i
     * 5. Traverse to all bars
     *
     * This method, we are using brute force to calculate the sum of water.
     *
     * Time complexity: O(n^2). Space complexity: O(1)
     * @param height
     * @return
     */
    public int trapBruteForce(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            int max = 0, maxLeft = 0, maxRight = 0, value = height[i];
            //calculate the left highest bar
            for(int left = 0; left < i; left++) {
                if(maxLeft < height[left]) {
                    maxLeft = height[left];
                }
            }
            //calculate the right highest bar
            for(int right = height.length - 1; right > i; right--) {
                if(maxRight < height[right]) {
                    maxRight = height[right];
                }
            }

            max = maxLeft <= maxRight ? maxLeft : maxRight;

            sum += max - value > 0 ? max - value : 0;
        }

        return sum;
    }

    /**
     * Use space to improve the time. Pre calculate the left and right max value. Use recursion.
     *
     * 1. Create two arrays: left[i] is the max value of [0, i-1]; right[i] is the max value of [i+1, n-1].
     * 2. Traverse height array and sum the value of min[left[i], right[i]] - height[i].
     *
     * Time complexity is O(n) (three n loops), space complexity is O(n).
     *
     *
     * @param height
     * @return
     */
    public int trapPrefixMax(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        int length = height.length, sum = 0;
        int[] left = new int[length], right = new int[length];
        for(int i = 0; i < length; i++) {
            left[i] = i == 0 ? height[i] : max(left[i - 1], height[i]);
        }
        for(int i = length - 1; i >= 0; i--) {
            right[i] = i == length - 1 ? height[i] : max(right[i + 1], height[i]);
        }

        for(int i = 0; i < length - 1; i++) {
            sum += min(left[i], right[i]) - height[i];
        }

        return sum;
    }

    /**
     * We don't need to use two arrays to hold the max and min height of each i.
     *
     * We can use two pointers leftWall and rightWall just like two walls to hold the water.
     *
     * 1. If leftWall >= rightWall stop. Else:
     * 2. If height[leftWall] < height[rightWall]:
     *      height[leftWall] decide the water: water = height[leftWall] - height[current]
     *      leftWall++
     * 3. Else:
     *
     *
     *
     * @param height
     * @return
     */
    public int trapTwoPointers(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }

        return 0;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private int min(int a, int b) {
        return a > b ? b : a;
    }
}

