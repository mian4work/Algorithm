import java.util.Stack;

/*
    This problem was asked by Facebook.

    You are given an array of non-negative integers that represents a two-dimensional elevation map where each
    element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two
    walls get filled up.

    Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

    For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

    Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the
    fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 */
public class DailyCoding {
    /**
     * The algorithm is to use two arrays to track the left highest bar and the right highest bar for each element i
     *
     * The result should be min(left[i], right[i]) - height[i] where:
     *      1. left keep the highest bar between 0..i-1
     *      2. right keep the highest bar between i+1..length-1.
     *
     * Use two dp arrays. The logic is simple: based on previous left/right height and calculate the current one.
     *
     * Left and right array save the index of highest.
     *
     * At the highest bar i, the left/right height is the h[i] itself.
     *
     * Time complexity is O(n) and space complexity is O(n)
     *
     * @param h
     * @return
     */
    public int trapArray(int[] h) {
        if(h == null || h.length == 0) {
            return 0;
        }

        int[] left = new int[h.length];
        int[] right = new int[h.length];
        int ans = 0;

        left[0] = h[0];
        right[h.length - 1] = h[h.length - 1];

        for(int i = 1; i < h.length; i++) {
            left[i] = Math.max(left[i - 1], h[i]); //compare previous highest with current one
        }

        for(int i = h.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], h[i]); //compare previous highest with current one
        }

        for(int i = 0; i < h.length; i++) {
            ans += Math.min(left[i], right[i]) - h[i];
        }

        return ans;
    }

    /**
     * The smart solution. We don't need two dp arrays to track the left/right highest, instead using two pointer
     *
     * The left pointer and right pointer are moving opposite to center.
     *
     * The leftMax record the left max height and right Max records the right max height.
     *      if leftMax is lower than rightMax, that means leftMax is the value to calculate the volume:
     *          if current left pointer's height is lower than leftMax, the volume is leftMax - (left pointer's height).
     *          if current left pointer's height is higher than leftMax, assign left pointer's height to leftMax
     *          left++ move one step right
     *
     *      if rightMat is lower than leftMax, we know rightMax is the bar to calculate the volume:
     *          if current right pointer's height is lower than rightMax, the volume is rightMax - (right pointer's height).
     *          if current right pointer's height is higher than rightMax, assign right pointer's height to rightMax
     *          right-- move one step left
     *
     * @param h
     * @return
     */
    public int trapTwoPointer(int[] h) {
        if(h == null || h.length == 0) {
            return 0;
        }

        int leftMax = h[0], rightMax = h[h.length - 1];
        int left = 0, right = h.length - 1;
        int sum = 0;

        while(left < right) {
            if(leftMax <= rightMax) { //leftMax is the determine point to calculate the volume
                if(h[left] < leftMax) {
                    sum += leftMax - h[left];
                } else {
                    leftMax = h[left];
                }

                left++;
            } else { //rightMax is the determine point to calculate the volume
                if(h[right] < rightMax) {
                    sum += rightMax - h[right];
                } else {
                    rightMax = h[right];
                }

                right--;
            }
        }

        return sum;
    }
}
