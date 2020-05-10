import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the
    town judge.

    If the town judge exists, then:

    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.
    You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

    If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

    Example 1:

    Input: N = 2, trust = [[1,2]]
    Output: 2

    Example 2:

    Input: N = 3, trust = [[1,3],[2,3]]
    Output: 3

    Example 3:

    Input: N = 3, trust = [[1,3],[2,3],[3,1]]
    Output: -1

    Example 4:

    Input: N = 3, trust = [[1,2],[2,3]]
    Output: -1

    Example 5:

    Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
    Output: 3


    Note:

    1 <= N <= 1000
    trust.length <= 10000
    trust[i] are all different
    trust[i][0] != trust[i][1]
    1 <= trust[i][0], trust[i][1] <= N
 */
public class Solution {

    /**
     * The best way to solve this kind of problem is to count each person's being trusted. At last, the person who have
     * N-1 person trust him is the judge. Smart one!!!
     * @param N
     * @param trust
     * @return
     */
    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N + 1]; //because person is 1 based.
        for(int[] t : trust) {
            count[t[0]]--; //this is important! if a person trusts other one, we need to make sure he is not judge!!
            count[t[1]]++;
        }

        for(int i = 1; i < count.length; i++) {
            if(count[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }
    /**
     * My first try. failed.
     *
     * The thought is to keep all persons and their trusts in a Map<Integer, List<Integer>>
     *      1. loop the map and get each person's trust list
     *      2. check if the other persons in the list. if their trust list size is not empty, remove that person from
     *          this person's list
     *      3. the final map should contains only one-element list
     *
     * The problem is that, when you are removing, you actually alter the final result!!!
     *
     * @param N
     * @param trust
     * @return
     */
    public int findJudgeFirstTry(int N, int[][] trust) {
        if(trust.length == 0) {
            return N == 1 ? 1 : -1;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        for(int i = 0; i < trust.length; i++) {
            list = map.getOrDefault(trust[i][0], new ArrayList<>());
            list.add(trust[i][1]);
            map.put(trust[i][0], list);
        }

        for(Integer p : map.keySet()) {
            list = map.get(p);
            for(int i = 0; i < list.size(); i++) {
                if(map.getOrDefault(list.get(i), new ArrayList<>()).size() > 0) {
                    list.remove(i);
                }
            }
        }

        int ans = -1;
        for(List<Integer> j : map.values()) {
            int size = j.size();
            if (size != 1) {
                return -1;
            }
            ans = j.get(0);
        }
        return ans;
    }
}
