import java.util.Stack;

/*
    You run an e-commerce website and want to record the last N order ids in a log.
    Implement a data structure to accomplish this, with the following API:

    record(order_id): adds the order_id to the log

    get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.

    You should be as efficient with time and space as possible.
 */
public class Solution {
    private Stack<Integer> log = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void record(int orderId) {
        log.push(orderId);
    }

    public Integer getLast(int i) {

        while (!log.empty()) {
            out.push(log.pop());
        }

        int index = 1;
        int result = 0;
        while (!out.empty()) {
            if (index == i) {
                result = out.peek();
            }

            log.push(out.pop());
            index++;
        }

        return result;
    }
}
