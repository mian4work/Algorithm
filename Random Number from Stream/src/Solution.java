import java.util.Random;

/**
    Given a stream of elements too large to store in memory, pick a random element from the stream
    with uniform probability.

    Or

    Given a stream of numbers, generate a random number from the stream. You are allowed to use only O(1) space
    and the input is in the form of a stream, so can’t store the previously seen numbers.

    Resources:
        https://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
        https://www.dailycodingproblem.com/blog/how-to-pick-a-random-element-from-an-infinite-stream/
 */
public class Solution {

    int result = 0, counter = 0;

    public int pick(int[] stream) {
        for(int i = 0; i < stream.length; i++) {
            selectRandom(stream[i]);
        }

        return result;
    }

    /**
     * This can be applied to many random related questions. If we don't know the length of an array (0..n), how do we
     * maintain the probability of 1/n for each element?
     *
     * When looping through each element in the stream, first n - 1 element's probability is 1 / (n - 1).
     * When we loop to the element n, to make element n - 1 to be probability 1/n, the factor is (n - 1 / n) because
     * (1 / n - 1) * (n - 1 / n) == 1/n
     *
     * The programming is quite simple: if counter == 1 (means the first element), return 1.
     * Then we select a random number between 0..(counter-1), if the INDEX of newly added element x equals counter-1,
     * x is returned as selected element. Don't know how this applied to the above calculation.
     *
     * This can be used for many other problems like get a random node on tree or linked lists etc.
     *
     * @param x
     * @return
     */
    public int selectRandom(int x) {
        counter++;

        if(counter == 1) {
            result = x;
        } else {
            Random random = new Random();
            int randomIndex = random.nextInt(counter); //this means random(0..counter-1) because array is 0 based.
            if(randomIndex == counter - 1) {
                result = x;
            }
        }

        return result;
    }
}
