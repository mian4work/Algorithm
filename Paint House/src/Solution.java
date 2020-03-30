/*
    There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
    The cost of painting each house with a certain color is different. You have to paint all the houses such that no
    two adjacent houses have the same color.

    The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
    For example, costs0 is the cost of painting house 0 with color red;
    costs1 is the cost of painting house 1 with color green, and so on…
    Find the minimum cost to paint all houses.
    
    Example: {{17,2,17}, {16, 16, 5}, {14,3,19}}
    min cost is 2 + 5 + 3 = 10

    Note: All costs are positive integers.
 */
public class Solution {

    /**
     * This is a costs problem.
     *
     * Using a same size matrix to record each room's min cost based on previous rooms's choice.
     * 
     * If the original array is allowed to be changed, we can directly use it.
     * 
     * The first house {17,2,17}, it's min cost for each color is it, no change.
     * 
     * The second house {16, 16, 5}, for each color, the total min cost is
     *      min of other two colors of previous house + it's own cost: {min(2, 17) + 16, min(17, 17) + 16, min(17, 2) + 5}
     *      {18, 33, 7}
     *      
     * The third house {14,3,19}, for each color, the total min cost so far is
     *      min total cost of other two colors of previous house + it's own cost: {min(33, 7) + 14, min(18, 7) + 3, min(18, 33) + 7}
     *      {21, 10, 25}
     *      
     * So the min total cost for painting three rooms is the min in {21, 10, 25} == 10
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) {
            return 0;
        }

        for(int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        return Math.min(Math.min(costs[costs.length - 1][0], costs[costs.length - 1][1]), costs[costs.length - 1][2]);
    }
}
