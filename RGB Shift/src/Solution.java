/*
    This problem was asked by Google.

    Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array so that all the Rs
    come first, the Gs come second, and the Bs come last. You can only swap elements of the array.

    Do this in linear time and in-place.

    For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'],
    it should become ['R', 'R', 'R', 'G', 'G', 'B', 'B'].

    This is also called "Dutch national flag problem" which use 0, 1, 2 to represent the color.
 */
public class Solution {
    /**
     * The concept is easy to under stand.
     *      Use "start" to record the next position to copy 'R'
     *      Use "end" to record the next position to copy 'G'
     *      Use "index' to traverse the array.
     *
     *      The end criteria to stop looping is index <= end && start < end
     *
     *      When find 'R' in index, swap to start position and start++, index++
     *      When find 'G' in index, do nothing
     *      When find 'B' in index, swap to end position and end--
     *          BUT, DON'T increase index BECAUSE we need to re-evaluate the newly swapped element in index
     *          if it is 'R', we need to swap it to the start.
     *          IMPORTANT ^^
     *
     * @param rgb
     * @return
     */
    public char[] shift(char[] rgb) {
        if(rgb == null || rgb.length == 0 || rgb.length == 1) {
            return rgb;
        }

        int start = 0, end = rgb.length - 1, index = 0;
        while(index <= end && start < end) {
            if(rgb[index] == 'R') {
                swap(rgb, start, index);
                index++;
                start++;
            } else if(rgb[index] == 'B') {
                swap(rgb, end, index);
                end--;
                //The key point here is not to increase index because the swapped element from end may be 'R'
                //so we have to stay at index to check if this element needs to be swapped again
            } else {
                //for 'G' do nothing
                index++;
            }
        }

        return rgb;
    }

    void swap(char[] rgb, int i, int j) {
        char temp = rgb[i];
        rgb[i] = rgb[j];
        rgb[j] = temp;
    }
}
