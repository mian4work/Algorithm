import java.util.*;

/*
    Design a data structure that supports all following operations in average O(1) time.

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability
    of being returned.

    Example:

    // Init an empty set.
    RandomizedSet randomSet = new RandomizedSet();

    // Inserts 1 to the set. Returns true as 1 was inserted successfully.
    randomSet.insert(1);

    // Returns false as 2 does not exist in the set.
    randomSet.remove(2);

    // Inserts 2 to the set, returns true. Set now contains [1,2].
    randomSet.insert(2);

    // getRandom should return either 1 or 2 randomly.
    randomSet.getRandom();

    // Removes 1 from the set, returns true. Set now contains [2].
    randomSet.remove(1);

    // 2 was already in the set, so return false.
    randomSet.insert(2);

    // Since 2 is the only number in the set, getRandom always return 2.
    randomSet.getRandom();
 */

/**
 * Use a Map and List to solve the problem.
 *      Use List to remember the index of a value
 *      Use Map to map value to index
 *
 * The most important tech learnt is:
 *      when removing, don't need to re-index the list
 *      just swap the index with last element in the list
 *      then remove the last in the list
 *      and remove the value from map
 *      and set the last index's value to the index.
 */
public class RandomizedSet {
    /** Initialize your data structure here. */
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rand = new Random();
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val);
            //if index == list.size() - 1, directly remove the last element in the list
            if(index < list.size() - 1) {
                int lastValue = list.remove(list.size() - 1);
                list.set(index, lastValue);
                map.put(lastValue, index);
            }
            map.remove(val);
            return true;
        }

        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int ran = rand.nextInt(list.size());
        return list.get(ran);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
