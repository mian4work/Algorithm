/*
    Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

    For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

    Follow-up: Can you do this in O(N) time and constant space?
 */

public class Solution {

    /**
     * It is hard for using brute force so I directly searched for result. This is a dp solution.
     *
     * The algorithm is smart but hard to explain:
     * 1. Use two variables: inclusive and exclusive:
     *          inclusive means what is the best sum include the current element i.
     *          exclusive means what is the best sum exclude the current element i.
     *          by using inclusive and exclusive, we calculate the non adjacent elements
     * 2. Loop through the array, for each element i:
     *          the current inclusive == max(previous_inclusive_sum, previous_exclusive_sum + input[i])
     *          the current exclusive == previous inclusive.
     * 3. Loop to the end, the last element's inclusive value is the result.
     *
     * @param input
     * @return
     */
    public int largestSumNonAdjacentNumbers(int[] input) {
        if(input == null || input.length == 0) {
            return 0;
        }

        int inclusive = 0, exclusive = 0;

        for(int i = 0; i < input.length; i++) {
            int preInclusive = inclusive, preExclusive = exclusive;
            exclusive = preInclusive;
            inclusive = max(preInclusive, preExclusive + input[i]);
        }

        return inclusive;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
