/*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

          *
        * *
        * *
        * *   *
    *   * * * *
    * * * * * *

    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

          *
        x x
        x x
        x x   *
    *   x x * *
    * * x x * *

    The largest rectangle is shown in the 'x' area, which has area = 10 unit.

    Example:

    Input: [2,1,5,6,2,3]
    Output: 10

 */

import java.util.Stack;

/*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

          *
        * *
        * *
        * *   *
    *   * * * *
    * * * * * *

    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

          *
        x x
        x x
        x x   *
    *   x x * *
    * * x x * *

    The largest rectangle is shown in the 'x' area, which has area = 10 unit.

    Example:

    Input: [2,1,5,6,2,3]
    Output: 10

 */
public class Solution {

    /**
     * Using brute force to calculate the result.
     *
     * Assuming heights[-1] == 0, heights[heights.length] == 0
     *
     * At any element i,
     *      try to find the first element on the left which heights[left] < height[i]
     *      try to find the first element on the right which heights[right] < height[i]
     *      So, the width == (right - left - 1) and the area is heights[i] * width
     *
     *      refer to image: https://i.loli.net/2018/10/29/5bd65b33c2798.png
     *
     * We can maintain two arrays to hold right and left elements where
     *      right[i] is the first element on the right which heights[right] < height[i]
     *      left[i] is the first element on the left which heights[right] < height[i]
     *
     *      Actually we don't need an array left and right, we only need two pointer to do the same work
     *      no need to save previous work.
     *
     * Use height[i] * (right[i] - left[i] - 1) to calculate the areas then find the max one.
     *
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaBruteForce(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        int[] left = new int[heights.length], right = new int[heights.length];
        int max = 0;

        for(int i = 0; i < heights.length; i++) {
            int l = i - 1, r = i + 1, leftValue = 0, rightValue = 0;
            left:
            while(l >= -1) {
                leftValue = l < 0 ? 0 : heights[l];
                if(leftValue < heights[i]) {
                    left[i] = l;
                    break left;
                } else {
                    l--;
                }
            }
            right:
            while(r <= heights.length) {
                rightValue = r >= heights.length ? 0 : heights[r];
                if(rightValue < heights[i]) {
                    right[i] = r;
                    break right;
                } else {
                    r++;
                }
            }

            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }

        return max;
    }

    /**
     * The brute force no array version
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaBruteForceNoArray(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int max = 0;

        for(int i = 0; i < heights.length; i++) {
            int l = i - 1, r = i + 1, leftValue = 0, rightValue = 0;
            left:
            while(l >= -1) {
                leftValue = l < 0 ? 0 : heights[l];
                if(leftValue < heights[i]) {
                    left = l;
                    break left;
                } else {
                    l--;
                }
            }
            right:
            while(r <= heights.length) {
                rightValue = r >= heights.length ? 0 : heights[r];
                if(rightValue < heights[i]) {
                    right = r;
                    break right;
                } else {
                    r++;
                }
            }

            max = Math.max(max, heights[i] * (right - left - 1));
        }

        return max;
    }

    /**
     * The clearest explanation is here: https://www.youtube.com/watch?v=RVIh0snn4Qc
     *
     * Refer to diagram: https://i.loli.net/2018/10/29/5bd65b33c2798.png
     *
     * Review it if confused again.
     *
     * The code is from leetcode, it clearly explained the algorithm.
     *
     * Remember, all what we need to do, is at any element, try to find the left and right boundary where their height
     * starts to be smaller than the element.
     *
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaStack(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        int len = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= len;) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            }else {
                int curHeight = heights[stack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (curHeight * width));
            }
        }
        return maxArea;
    }
}
