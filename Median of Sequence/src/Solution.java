/*
    This problem was asked by Microsoft.

    Compute the running median of a sequence of numbers. That is, given a stream of numbers,
    print out the median of the list so far on each new element.

    Recall that the median of an even-numbered list is the average of the two middle numbers.

    For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

    2
    1.5
    2
    3.5
    2
    2
    2
 */
public class Solution {

    /**
     * Easy one.
     *
     * Use a pointer p to point to the median position. if there are odd number of element, arr[p], else (arr[p] + arr[p+1])/2
     *
     * sort the element while moving, if arr[i] >= arr[i-1], get median number by using p.
     * else, move element i to the right position and get median number.
     * 
     * @param arr
     */
    public void median(int[] arr) {
        if(arr == null || arr.length == 0) {
            System.out.println("No elements");
            return;
        }

        /*  median pointer.
            when new i is even, p+1. it means there are odd elements in the list so far to i
            when new i is odd, p is unchanged. it means there are even elements in the list so far to i

            when new i is even, media == arr[p]
            when new i is odd, media == arr[p] + arr[p+1]
         */
        int p = 0;
        System.out.println(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i - 1]) {
                int j = i;
                /*
                    move new element i to the right sorted position if arr[i] < arr[i - 1]
                 */
                while(j > 0 && arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    j--;
                }
            }

            if(i % 2 == 0) {
                System.out.println(arr[p]);
            } else {
                System.out.println((double)(arr[p] + arr[p + 1]) / 2);
                p++;
            }
        }
    }
}
