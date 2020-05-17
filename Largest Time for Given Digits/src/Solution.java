import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given an array of 4 digits, return the largest 24 hour time that can be made.

    The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time
    has elapsed since midnight.

    Return the answer as a string of length 5.  If no valid time can be made, return an empty string.



    Example 1:

    Input: [1,2,3,4]
    Output: "23:41"

    Example 2:

    Input: [5,5,5,5]
    Output: ""

    Note:

    A.length == 4
    0 <= A[i] <= 9
 */
public class Solution {
    /**
     * The brute force permutation solution.
     *
     * Loop through A 4 times, when the index are different, calculate the total minutes.
     *      If they are unqualified, return -1
     *      Otherwise, format it to hh:mm
     *      Note the format should be %02d
     *
     * @param A
     * @return
     */
    public String largestTimeFromDigits(int[] A) {

        //brute force permutation
        int max = -1;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(i != j) {
                    for(int k = 0; k < 4; k++) {
                        if(k != i && k != j) {
                            // 0,1,2,3 总和为6，故剩下的index为6-
                            int l = 6 - i - j - k;
                            int time = largest(A[i], A[j], A[k], A[l]);
                            max = Math.max(max, time);
                        }
                    }
                }
            }
        }

        if(max == -1) {
            return "";
        }
        return String.format("%02d:%02d", max / 60, max % 60);
    }

    private int largest(int a, int b, int c, int d) {
        int hour = a * 10 + b;  //must be smaller than 24
        int min = c * 10 + d; //must be smaller than 60;

        if(hour < 24 && min < 60) {
            return hour * 60 + min; //return the minutes
        }

        return -1;
    }

    /**
     * First try failed. For example: [2,0,6,6] output is "" but should be "06:26"
     *
     * @param A
     * @return
     */
    public String largestTimeFromDigitsFirstTry(int[] A) {
        Arrays.sort(A);
        List<Integer> list = new ArrayList<Integer>();
        for(int i = A.length - 1; i >= 0; i--) {
            list.add(A[i]);
        }

        int h1 = 0, h2 = 0, m1 = 0, m2 = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) < 3) {
                h1 = list.get(i);
                list.remove(i);
                break;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            if((h1 > 0 && list.get(i) < 4) || (h1 == 0 && list.get(i) < 10)) {
                h2 = list.get(i);
                list.remove(i);
                break;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) < 6) {
                m1 = list.get(i);
                list.remove(i);
                break;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) < 10) {
                m2 = list.get(i);
                list.remove(i);
            }
        }

        if(list.size() == 0) {
            return "" + h1 + h2 + ":" + m1 + m2;
        } else {
            return "";
        }
    }
}
