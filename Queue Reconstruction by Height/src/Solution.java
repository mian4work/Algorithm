import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
    Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
    where h is the height of the person and k is the number of people in front of this person who have a height greater
    than or equal to h. Write an algorithm to reconstruct the queue.

    Note:
    The number of people is less than 1,100.


    Example

    Input:
    [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

    Output:
    [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Solution {
    /**
     * Start from tallest persons because they are supposed to be in right position.
     * Then add shorter persons in. For example:
     *      1. first loop we get: [[7,0], [7,1]]. this is a correct order
     *      2. second loop we get: [[7,0], [6, 1], [7,1]].
     *      3. third loop we get: [[5, 0], [7,0], [5, 1], [6, 1], [7,1]].
     *
     * One more important thing to be noticed:
     *      When sorting persons from tallest to shortest,
     *      if two person's height are the same, sort them from lower position to higher one.
     *
     *      for example:
     *      before: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     *      after:  [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
     *      not:    [[7,1], [7,0], [6,1], [5,2], [5,1], [4,4]] otherwise the result is wrong.
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        if(people == null) {
            return null;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(people, (x, y) -> {
            if(x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return y[0] - x[0];
            }
        });
        for(int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][2]);
    }

    /**
     * First try failed. I start from smallest persons that ends up with no solution
     * @param people
     * @return
     */
    public int[][] reconstructQueueFirstTry(int[][] people) {
        if(people == null) {
            return null;
        }
        int len = people.length;
        int[][] arr = new int[len][2];
        Arrays.sort(people, Comparator.comparingInt(x -> x[0]));
        for(int i = 0; i < len; i++) {
            int position = people[i][1];
            while(position < len && isOccupied(arr, position)) {
                position++;
            }
            arr[position] = people[i];
        }

        return arr;
    }

    boolean isOccupied(int[][] arr, int index) {
        if(arr[index][0] == 0 && arr[index][1] == 0) {
            return false;
        }

        return true;
    }
}
