import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    There are N network nodes, labelled 1 to N.

    Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
    v is the target node, and w is the time it takes for a signal to travel from source to target.

    Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
    If it is impossible, return -1.

    Example 1:

    https://assets.leetcode.com/uploads/2019/05/23/931_example_1.png
    Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
    Output: 2

    Note:

    N will be in the range [1, 100].
    K will be in the range [1, N].
    The length of times will be in the range [1, 6000].
    All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */
public class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        //construct a map from times with start as key, (end, time) as value. the value is always in pairs
        Map<Integer, List<Integer>> map = new HashMap<>();
        //transform the times
        for(int i = 0; i < times.length; i++) {
            List<Integer> list = null;
            if(map.get(times[i][0]) == null) {
                list = new ArrayList<>();
            } else {
                list = map.get(times[i][0]);
            }

            list.add(times[i][1]);
            list.add(times[i][2]);
            map.put(times[i][0], list);
            map.put(times[i][1], new ArrayList<>());
        }

        if(map.keySet().size() < N) {
            return -1;
        } else {
            int[] max = new int[1];
            return dfs(map, K, max);
        }
    }

    int dfs(Map<Integer, List<Integer>> map, int current, int[] max) {
        List<Integer> list = map.get(current);
        if(list.size() == 0) {
            return 0;
        }

        for(int i = 0; i < list.size() - 1; i += 2) {
            max[0] = Math.max(max[0], list.get(i + 1) + dfs(map, list.get(i), max));
        }

        return max[0];
    }
}
