import java.util.Arrays;

/*
    Given an array w of positive integers, where w[i] describes the weight of index i, write a function
    pickIndex which randomly picks an index in proportion to its weight.

    Note:

    1 <= w.length <= 10000
    1 <= w[i] <= 10^5
    pickIndex will be called at most 10000 times.

    Example 1:

    Input:
    ["Solution","pickIndex"]
    [[[1]],[]]
    Output: [null,0]

    Example 2:

    Input:
    ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
    [[[1,3]],[],[],[],[],[]]
    Output: [null,0,1,1,1,0]

    Explanation of Input Syntax:

    The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument,
    the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class Solution {
    double[] p;

    /**
     * The description of the problem is confusing.
     *
     * This explanation is from leetcode:
     *
     * The problem is, we need to randomly pick an index proportional to its weight.
     * What this means?
     * We have weights array, each
     * weights[i]  represents weight of index i.
     * The more the weight is, then high chances of getting that index randomly.
     *
     * suppose weights = [1, 3]
     * then 3 is larger, so there are high chances to get index 1.
     *
     * We can know the chances of selecting each index by knowing their probability.
     *
     * P(i) = weight[i]/totalWeight
     *
     * totalWeight = 1 + 3 = 4
     * So, for index 0, P(0) = 1/4  = 0.25 = 25%
     * for index 1, P(1) = 3/4 = 0.75 = 75%
     *
     * So, there are 25% of chances to pick index 0 and 75% chances to pick index 1.
     *
     * I have provided java code for this problem in the comment section.
     * If you are interested, you can check that. Happy coding.
     *
     * Also notice that the probability is cumulative:
     *
     * for weights [1, 4, 5]
     * 10% chances of getting index 0
     * 40% chances of getting index 1
     * 50% chances of getting index 2.
     * Choose a random number between 0 to 1.
     * Cumulative probabilities [0.1, 0.5, 1.0]
     * If random is between 0 - 0.1, then return index 0.
     * If it is between 0.1 - 0.5, then return index 1.
     * If it is between 0.5 - 1.0, then return index 2.
     *
     *
     * @param w
     */
    public Solution(int[] w) {
        int sum = 0;
        double[] p = new double[w.length];
        for(int weight : w) {
            sum += weight;
        }

        for(int i = 0; i < w.length; i++) {
            w[i] += i == 0 ? 0 : w[i - 1];
            p[i] = (double)w[i] / sum;
        }
        this.p = p;
    }

    /**
     * Need to know the binarySearch, which is different from regular search. It returns the insertion position.
     *
     * @return
     */
    public int pickIndex() {
        //return search(p, Math.random());
        return Math.abs(Arrays.binarySearch(p, Math.random())) - 1;
    }

    int search(double[] p, double ran) {
        int start = 0, end = p.length - 1, mid;
        while(start < end) {
            mid = (start + end) / 2;
            if(p[mid] < ran) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
