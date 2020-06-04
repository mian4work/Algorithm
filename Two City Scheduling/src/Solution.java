import java.util.*;

/*
    There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is
    costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

    Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.



    Example 1:

    Input: [[10,20],[30,200],[400,50],[30,20]]
    Output: 110
    Explanation:
    The first person goes to city A for a cost of 10.
    The second person goes to city A for a cost of 30.
    The third person goes to city B for a cost of 50.
    The fourth person goes to city B for a cost of 20.

    The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.


    Note:

    1 <= costs.length <= 100
    It is guaranteed that costs.length is even.
    1 <= costs[i][0], costs[i][1] <= 1000
 */
public class Solution {
    /**
     * How to solve this problem?
     *
     * The idea is this:
     *      1. Assuming sending all persons to A, we can get a total cost
     *      2. Then we can see who is the most expensive cost for a person to A.
     *      3. Replace the most expensive ones to B to see if the cost can be lowered.
     *      4. Keep replacing until half of persons to A and half to B
     *      5. Get the total cost
     *
     *      Think in detail, the diff between person i's cost to A and B (cost[i][0] - cost[i][1])
     *      Sort this diff, in ascending order and pick the first half for A and second half for B
     *
     *      ref: https://www.youtube.com/watch?v=cevaICIEyjs
      * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));

        int sum = 0;
        for(int i = 0; i < costs.length; i++) {
            if(i < costs.length / 2) {
                sum += costs[i][0];
            } else {
                sum += costs[i][1];
            }
        }

        return sum;
    }

    /**
     * First try failed. Using priority queue is not the right way to go.
     *
     * Switch to dp to see if it can solve the problem.
     *
     * @param costs
     * @return
     */
    public int twoCitySchedCostFirstTry(int[][] costs) {
        PriorityQueue<Person> aQueue = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        PriorityQueue<Person> bQueue = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        List<Integer> list = new ArrayList<>();
        int half = costs.length / 2;

        for(int i = 0; i < costs.length; i++) {
            Person a = new Person(i, costs[i][0]);
            Person b = new Person(i, costs[i][1]);
            aQueue.offer(a);
            bQueue.offer(b);
        }

        while(list.size() < costs.length) {
            if(aQueue.peek().cost <= bQueue.peek().cost) {
                list.add(aQueue.poll().cost);
            } else if(aQueue.peek().cost > bQueue.peek().cost) {
                list.add(bQueue.poll().cost);
            }
        }

        int sum = 0;
        for(int c : list) {
            sum += c;
        }

        return sum;
    }
}

class Person {
    int index;
    int cost;

    public Person(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    public boolean equals(Person b) {
        return this.index == b.index;
    }
}
