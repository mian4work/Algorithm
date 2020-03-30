/*
    A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing
    cost while ensuring that no two neighboring houses are of the same color.

    Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color,
    return the minimum cost which achieves this goal.

    example, costs[0][0] is the cost of painting house 0 with color 0;
    costs[1][2] is the cost of painting house 1 with color 2, and so on..

    Example: {{17,2,17}, {16, 16, 5}, {14,3,19}}
    min cost is 2 + 5 + 3 = 10
 */
public class Solution {
    /**
     * Brute Force
     *
     * Calculate the min cost of one house and make sure it doesn't include the color of previous house
     * then sum up.
     *
     * Time complexity: O(n*k)
     *
     * @param costs
     * @return
     */
    public int minCostBruteForce(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        int minCost = 0;
        int previousColor = -1;
        int currentColor = 0;
        for(int i = 0; i < costs.length; i++) {
            int minHouseCost = Integer.MAX_VALUE;
            for(int j = 0; j < costs[i].length; j++) {
                if(previousColor != j) {
                    if (minHouseCost > costs[i][j]) {
                        minHouseCost = costs[i][j];
                        currentColor = j;
                    }
                }
            }
            minCost += minHouseCost;
            previousColor = currentColor;
        }

        return minCost;
    }

    /**
     * Reference to Paint House comment: https://github.com/mian4work/Algorithm/blob/master/Paint%20House/src/Solution.java#L18
     *
     * This is not the most efficient way to do the work.
     *
     * Time complexity O(n*k*k)
     *
     * @param costs
     * @return
     */
    public int minCostDP(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        for(int i = 1; i < costs.length; i++) {
            for(int j = 0; j < costs[i].length; j++) {
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < costs[i].length; k++) {
                    if(k != j && min > costs[i - 1][k]) {
                        min = costs[i - 1][k];
                    }
                }
                costs[i][j] += min;
            }
        }

        int minCost = Integer.MAX_VALUE;
        int len = costs.length - 1;
        for(int i = 0; i < costs[len].length; i++) {
            minCost = Math.min(minCost, costs[len][i]);
        }

        return minCost;
    }
}
