import java.util.Set;

/*
   You are climbing a stair case. It takes n steps to reach to the top.

    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Note: Given n will be a positive integer.

    Example 1:

        Input: 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step
        2. 2 steps

    Example 2:

        Input: 3
        Output: 3
        Explanation: There are three ways to climb to the top.
        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step
 */
/*
    What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X?
    For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
 */
public class Solution {

    /**
     * This a Fibonacci problem.
     *
     * If stair is 0 or 1, the step is 1.
     * Then the rest step is the previous step + previous_previous step: climb(n) = climb(n-1) + climb(n-2).
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * Given a set of climb ways, do it one by one.
     * @param n
     * @param x
     * @return
     */
    public int climbStairs(int n, Set<Integer> x) {
        if(n == 0 || n == 1) {
            return 1;
        }
        
        return x.stream().reduce((a, b) -> climbStairs(n - a, x) + climbStairs(n - b, x)).get();
    }
}
