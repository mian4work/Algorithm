import java.util.*;

public class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(dislikes == null || dislikes.length == 0) {
            return true;
        }

        int[] color = new int[N];
        for(int[] dislike : dislikes) {
            if(color[dislike[0]] == 0) {
                color[dislike[0]] = 1;
                color[dislike[1]] = 2;
            }
        }

        return false;
    }

    public boolean possibleBipartitionSecondTry(int N, int[][] dislikes) {
        if(dislikes == null || dislikes.length == 0) {
            return true;
        }

        Set<Integer> v1 = new HashSet<>();
        Set<Integer> v2 = new HashSet<>();

        for(int[] dislike : dislikes) {
            if(v1.contains(dislike[0]) && v2.contains(dislike[1])) {
                return false;
            }

            v1.add(dislike[0]);
            v1.add(dislike[1]);
            v2.add(dislike[0]);
            v2.add(dislike[1]);
        }

        return true;
    }


    public boolean possibleBipartitionFirstTry(int N, int[][] dislikes) {
        if(dislikes == null || dislikes.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] p : dislikes) {
            List<Integer> list;
            if(map.get(p[0]) == null) {
                list = new ArrayList<>();
            } else {
                list = map.get(p[0]);
            }
            list.add(p[1]);
            map.put(p[0], list);
        }

        return dfs(map, new int[1], 0, N);
    }

    boolean dfs(Map<Integer, List<Integer>> map, int[] sum, int index, int N) {
        if(sum[1] == N) {
            return false;
        }
        List<Integer> list = map.get(index);

        sum[0]++;
        boolean ans = false;
        if(list != null) {
            for(Integer target : list) {
                ans = ans || dfs(map, sum, target, N);
            }
        }

        return true;
    }
}
