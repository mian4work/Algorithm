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

public class Solution {

    /**
     * The clearest explanation is here: https://www.youtube.com/watch?v=RVIh0snn4Qc
     *
     * Review it if confused again.
     *
     * Basically, a stack is used to save the index
     *      define an anchor pointer: anchor (which is index i)
     *      loop the array (0..length-1)
     *      if i == 0; push i: first element
     *      if height[stock.peek()] <= height[i]:
     *          push i.
     *          you can think height[peek] can merge into height[i] because it is shorter.
     *          in stack, the sequence now is from highest to lowest index
     *      if height[stock.peek()] > height[i]:
     *          pop top and calculate the area with width,
     *          until the index saved in stack is shorter height[peek] < height[i]
     *          so width is i - peek - 1
     *
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaStack(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for(int i = 0; i <= heights.length; i++) {
            if(!stack.empty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                while(heights[stack.peek()] >= heights[i]) {

                }
            } else {
                stack.push(i);
            }
        }

        return max;
    }
}
