import java.util.ArrayList;
import java.util.List;

/*
    This problem was asked by Google.

    The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

    For example, given the set {1, 2, 3}, it should return
    {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

    You may also use a list or array to represent a set.
 */
public class Solution {
    /**
     * This may not be the most efficient way.
     *
     *      1. For a set, add it to power.
     *      2. For each element in the set, form a sub set without this element and run recursively.
     *      3. When set size is 0, return.
     *      4. Important part is: when a set exist in the power, return. Otherwise, it will be duplicated.
     *
     *      Using set may be a good idea.
     *
     * @param set
     * @return
     */
    public List<List<Integer>> powerSet(List<Integer> set) {
        if(set == null || set.size() == 0) {
            return null;
        }

        List<List<Integer>> power = new ArrayList<>();
        power.add(new ArrayList<>()); //add empty list
        helper(set, power);
        return power;
    }

    void helper(List<Integer> set, List<List<Integer>> power) {
        if(set.size() == 0 || power.contains(set)) {
            return;
        }

        power.add(set);
        for(int i = 0; i < set.size(); i++) {
            //subset without element i
            List<Integer> subSet = new ArrayList<>(set.subList(0, i));
            subSet.addAll(set.subList(i + 1, set.size()));
            helper(subSet, power);
        }
    }
}
