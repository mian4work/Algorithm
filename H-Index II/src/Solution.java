/*
    Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
    write a function to compute the researcher's h-index.

    According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at
    least h citations each, and the other N − h papers have no more than h citations each."

    Example:

    Input: citations = [0,1,3,5,6]
    Output: 3
    Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
                 received 0, 1, 3, 5, 6 citations respectively.
                 Since the researcher has 3 papers with at least 3 citations each and the remaining
                 two with no more than 3 citations each, her h-index is 3.
    Note:

    If there are several possible values for h, the maximum one is taken as the h-index.

    Follow up:

    This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
    Could you solve it in logarithmic time complexity?
 */
public class Solution {
    /**
     * Change the descriptions to below which is easy to understand the problem:
     *
     *      Find max value M, such that you have at least M numbers in the array which values are >= M
     *      and the rest of numbers in array (len - M) are <= M
     *
     * To solve this problem, we should first sort the array (in this version II, it is sorted already)
     *      1. at any index i, check citations[i] >= len - i (means the rest of element numbers)
     *      2. if so, return len - i because and index j > i, the result (n - j) < (n - i), so (n - i) is the max.
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if(citations == null) {
            return 0;
        }
        int len = citations.length;
        for(int i = 0; i < len; i++) {
            //len - i means the number of citations which are >= M because the array is sorted
            if(citations[i] >= len - i) {
                //directly return because if j > i, (len - j) < (len - i) so (len - i) is max value
                return len - i;
            }
        }

        return 0;
    }

    /**
     * My first try failed because of not fully understanding the question!!!
     *
     * @param citations
     * @return
     */
    public int hIndexFirstTry(int[] citations) {
        if(citations == null ) {
            return 0;
        }

        int len = citations.length;
        int h = 0;
        for(int i = 0; i < len; i++) {
            if(len - citations[i] == i) {
                h = Math.max(h, citations[i]);
            }
        }

        return h;
    }
}
