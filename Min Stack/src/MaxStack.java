import java.util.ArrayList;
import java.util.List;

/*
    This problem was asked by Amazon.

    Implement a stack that has the following methods:

    push(val), which pushes an element onto the stack.

    pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack,
    then it should throw an error or return null.

    max(), which returns the maximum value in the stack currently. If there are no elements in the stack,
    then it should throw an error or return null.

    Each method should run in constant time.
 */
public class MaxStack {
    List<Element> stack = new ArrayList<>();

    public void push(int value) {
        Element e = new Element(value);

        if(max() == null || value > max()) {
            e.setMax(value);
        } else {
            e.setMax(max());
        }

        stack.add(e);
    }

    public Integer pop() {
        if(stack.isEmpty()) {
            return null;
        } else {
            return stack.get(0).value;
        }
    }

    public Integer max() {
        if(stack.isEmpty()) {
            return null;
        } else {
            return stack.get(0).currentMax;
        }
    }
}
