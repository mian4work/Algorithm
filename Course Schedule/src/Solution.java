import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * The algorithm is called topological sort:
     *      1. count each node's incoming lines (called in-degree) and saved in an array
     *      2. from node which in-degree is 0, put it in a queue
     *      3. move to its neighbours and cut the lines between the node and neighbours by decreasing it's in-degree
     *         number.
     *      4. put all neighbours which in-degree is 0 to a queue
     *      5. repeat the process
     *      6. if any element in in-degree array is not 0, that means there is a loop in the graph, return false
     *      7. otherwise, return true
     *
     *      ref: https://www.youtube.com/watch?v=L05HDfyDHjg
     *      
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        for(int[] v : prerequisites) {
            inDegree[v[0]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int start = queue.poll();
            for(int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == start) {
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        for(int i : inDegree) {
            if(i != 0) {
                return false;
            }
        }

        return true;
    }


    /**
     * First try. Failed.
     *
     * The thought is:
     *      try to find the loop in the graph
     *      create a visited boolean list
     *      mark start from prerequisites to be true
     *      check if end is in the visited list
     *
     *      This won't work for [1, 0] [2, 1]
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishFirstTry(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        //if we can find a cycle in prerequisites graph, return false
        boolean[] visited = new boolean[numCourses];

        return dfs(prerequisites, visited, 0);
    }

    boolean dfs(int[][] prerequisites, boolean[] visited, int row) {
        boolean ans = true;
        if(row >= prerequisites.length) {
            return true;
        }

        int start = prerequisites[row][1], end = prerequisites[row][0];
        visited[start] = true;
        if(visited[end]) {
            ans = false;
        }

        return ans && dfs(prerequisites, visited, row + 1);
    }
}
