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
     * Using Brute Force to solve this problem.
     * A index pointer is used to check the height of current block. If the next block is greater than the current one, index++ because the next one
     * for sure is greater than the current one together.
     * Else, start calculating:
     *      height[index] is the current greatest block.
     *      i from (index..0):
     *      We have a group of results
     *          height[index] * 1 --> the highest block itself
     *          height[index - 1] * 2 --> the lower neighbor times 2 (width)
     *          height[index - 3] * 3 --> the lower next neighbor times 3 (width)
     *          ...
     *          height[0] * index --> the first one times index (width)
     *
     *          Find the max number and save it for future.
     *          Remember the index as last
     *
     *          keep incrementing index pointer and back trace to (last + 1) if next to index is lower
     *
     * Above example:
     *      index = 0:  the next one is lower (1) so the max num is 2. last = 0
     *      index = 1:  the next one is higher(5) keep going
     *      index = 2:  the next one is higher(6) keep going
     *      index = 3:  the next one is lower (2) start calculating:
     *          at index = 3:   6 * 1 = 6
     *          at index = 2:   5 * 2 = 10
     *          at index = 1:   1 * 3 = 3 (stop at last + 1 == 1)
     *          max num = 10 and last = 3
     *
     *     index = 4:   the next one is higher (3) keep going
     *     index = 5:   the next one is end, start calculating:
     *      at index = 5:   3 * 1 = 3
     *      at index = 4:   2 * 2 = 4 (stop at last + 1 == 4)
     *      max num = 4
     *
     *    Compare three max: 2, 10, 4, we know the result is 10
     *
     *    The time complexity is O(n^2)
     *
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaBruteForce(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        int last = 0, max = 0;
        for(int i = 0; i < heights.length; i++) {
            if(i + 1 >= heights.length || heights[i] > heights[i + 1]) {
                //start calculating
                int index = 1;
                for(int j = i; j > last; j--) {
                    max = max < heights[j] * index ? heights[j] * index : max;
                    index++;
                }
                last = i;
            }
        }

        return max;
    }

    /**
     * Using Stack to solve this problem.
     *
     * The purpose is to
     *      find left border of i which height[left] < height[i]
     *      find right border of i which height[right] < height[i].
     *
     * So, a stack is used. The top element of the stack is always the tallest bar.
     *      when it is empty, push current i in it.
     *      when it is not empty, check if current height[i] > height[stack.peek()] (the top element).
     *          if yes, push index i to stack
     *          if not, start calculating:
     *              use a pointer 'width' to record the width
     *              pop top element and multiply with width
     *              pop second element and multiply with width+1
     *              pop third element and multiply with width+2
     *              ...
     *              until stack is empty
     *              find the largest one in all multiplies.
     *
     *      repeat...
     *
     * Above example: [2,1,5,6,2,3], max=0
     *      index = 0:  the stack is empty. push 0. stack: 0
     *      index = 1:  height[1] == 2 < height[stack.peek()] : height[0] == 1:
     *          set width = 1
     *          stack.pop == 0, height[0] * width = 2
     *          max = 2
     *          push 1
     *      index = 2:  the stack is empty. push 2. stack: 2
     *      index = 3:  height[3] == 2 > height[stack.peek()] == 5, push 3. stack: 3 2
     *     index = 4:   height[4] == 2 < height[stack.peek()] == 6
     *          set width = 1
     *          stack.pop == 3, height[3] * width = 6 * 1
     *          max = 6, width = 2
     *          stack.pop == 2, height[2] * width = 5 * 2
     *          max = 10
     *     index = 5:   the stack is empty. push 5. stack: 5
     *      at index = 5:   3 * 1 = 3
     *      at index = 4:   2 * 2 = 4 (stop at last + 1 == 4)
     *      max num = 4
     *
     *    Compare three max: 2, 10, 4, we know the result is 10
     *
     *    The time complexity is O(n^2)
     *
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaStack(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        if(heights.length == 1) {
            return heights[0];
        }

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for(int i = 0; i < heights.length; i++) {
            if(!stack.empty() && heights[i] < heights[stack.peek()]) {
                int width = 1;
                while(!stack.empty()) {
                    int value = heights[stack.pop()] * width;
                    max = max < value ? value : max;
                    width++;
                }
            }

            stack.push(i);
        }

        return max;
    }

    /**
     * For any given block i,
     *      find its first one which is smaller than it on left side: left
     *      find its first one which is smaller than it on right side: right
     *      use it height height[i] * (width between left and right exclusively)
     *
     * Example: above histogram [2,1,5,6,2,3] at index == 2 (height[2] = 5)
     *      first one smaller than it is at 1 (height[1] = 1)
     *      first one smaller than it is at 4 (height[4] = 2)
     *      the area is 5 * (4 - 1 - 1) == 10
     *
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaTwoStack(int[] heights) {
        return 0;
    }
}
