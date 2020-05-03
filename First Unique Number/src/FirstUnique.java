import java.util.*;
/*
    You have a queue of integers, you need to retrieve the first unique integer in the queue.

    Implement the FirstUnique class:

    FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
    int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
    void add(int value) insert value to the queue.

    Example 1:

    Input:
    ["FirstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
    [[[2,3,5]],[],[5],[],[2],[],[3],[]]
    Output:
    [null,2,null,2,null,3,null,-1]

    Explanation:
    FirstUnique firstUnique = new FirstUnique([2,3,5]);
    firstUnique.showFirstUnique(); // return 2
    firstUnique.add(5);            // the queue is now [2,3,5,5]
    firstUnique.showFirstUnique(); // return 2
    firstUnique.add(2);            // the queue is now [2,3,5,5,2]
    firstUnique.showFirstUnique(); // return 3
    firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
    firstUnique.showFirstUnique(); // return -1

    Example 2:

    Input:
    ["FirstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
    [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
    Output:
    [null,-1,null,null,null,null,null,17]

    Explanation:
    FirstUnique firstUnique = new FirstUnique([7,7,7,7,7,7]);
    firstUnique.showFirstUnique(); // return -1
    firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
    firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
    firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
    firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
    firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
    firstUnique.showFirstUnique(); // return 17

    Example 3:

    Input:
    ["FirstUnique","showFirstUnique","add","showFirstUnique"]
    [[[809]],[],[809],[]]
    Output:
    [null,809,null,-1]

    Explanation:
    FirstUnique firstUnique = new FirstUnique([809]);
    firstUnique.showFirstUnique(); // return 809
    firstUnique.add(809);          // the queue is now [809,809]
    firstUnique.showFirstUnique(); // return -1



    Constraints:

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^8
    1 <= value <= 10^8
    At most 50000 calls will be made to showFirstUnique and add.
 */
public class FirstUnique {
    Map<Integer, List<Integer>> map = new HashMap<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    List<Integer> numsList = new ArrayList<>();

    /**
     * I am using a Map to reverse map the value to index. If more than one values exist, the indexes are saved as array.
     *
     * Once it is converted, transverse the map and find the values with only one element in index array and save the
     * indexes in a min priority queue (a heap).
     *
     * Another way is to implement a Map with value also be the element of a doubly linked list.
     *
     * @param nums
     */
    public FirstUnique(int[] nums) {
        List<Integer> list;
        for(int i = 0; i < nums.length; i++){
            numsList.add(i, nums[i]);
            list = map.containsKey(nums[i]) ? map.get(nums[i]) : new ArrayList<>();
            list.add(i);
            map.put(nums[i], list);
        }

        for(Integer key : map.keySet()) {
            if(map.get(key).size() == 1) {
                queue.add(map.get(key).get(0));
            }
        }
    }

    public int showFirstUnique() {
        return queue.size() == 0 ? -1 : numsList.get(queue.peek());
    }

    public void add(int value) {
        numsList.add(value);
        List<Integer> list;
        int index = numsList.size() - 1;
        if(!map.containsKey(value)) {
            queue.add(index);
            list = new ArrayList<>();
        } else {
            list = map.get(value);
            if(list.size() == 1) {
                queue.remove(list.get(0));
            }
        }
        list.add(index);
        map.put(value, list);
    }
}
