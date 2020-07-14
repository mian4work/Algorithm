import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    This question can be simplified as this:
    find the length of sub string with repeated char.

    Example 1:

    [a, b, c] result is [1, 1, 1] because each char is unique

    Example 2:
    [a, b, b, a, e, f, e, d, f, e, d, j, k] result is [4, 7, 2]
    because a, b, b, a is a repeated char string, length 4
    e, f, e, d, f, e, d is another, length 7
    j, k is the third, length 2

 */
public class Solution1 {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> lengthEachScene(List<Character> inputList)
    {
        // WRITE YOUR CODE HERE
        if(inputList == null) {
            return null;
        }

        Set<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        //using sliding window tech
        int start = 0, end = start + 1;
        while(start < inputList.size()) {
            set.add(inputList.get(start));
            int count = 0;
            while(end < inputList.size() - 1) {
                if(set.contains(inputList.get(start))) {

                }
            }
        }

        return list;
    }
    // METHOD SIGNATURE ENDS
}
