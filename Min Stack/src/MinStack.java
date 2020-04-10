import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.


    Example:

    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.
*/

/**
 * The key point is to hold a min value on each 'Node'.
 * My solution somehow can't passes the test cases.
 * But the solution here also has problems: what is head is null when pop?
 */
class MinStack {
    private Node head;

    public void push(int x) {
        if(head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
//public class MinStack {
//    List<StackNode> stack = new ArrayList<>();
//    Integer min;
//
//    public MinStack() {
//
//    }
//
//    public void push(int x) {
//        min = min == null ? x : Math.min(min, x);
//        StackNode node = new StackNode(x);
//        node.min = min;
//        stack.add(0, node);
//    }
//
//    public void pop() {
//        if(!stack.isEmpty()) {
//            StackNode node = stack.remove(0);
//            if (min == node.value && !stack.isEmpty()) {
//                min = stack.get(0).min;
//            }
//        }
//    }
//
//    public int top() {
//        if(!stack.isEmpty()) {
//            return stack.get(0).value;
//        } else {
//            return 0;
//        }
//    }
//
//    public int getMin() {
//        return min == null ? Integer.MAX_VALUE : min;
//    }
//}
