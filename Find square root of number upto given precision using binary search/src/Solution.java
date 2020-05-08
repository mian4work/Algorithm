/*
    Given a positive number n and precision p, find the square root of number upto p decimal places using binary search.
 */
public class Solution {
    public float squareRoot(int number, int precision) {
        if(number == 0) {
            return 0;
        }

        //binary search start from 0 to number
        int start = 0, end = number;
        float ans = 0;
        while(start <= end) {
            int mid = end - (end - start) / 2;
            float sqr = mid * mid;
            if (sqr == number) {
                ans = mid;
                break;
            } else if (sqr > number) {
                end = mid - 1;
            } else if (sqr < number) {
                start = mid + 1;
                ans = mid; // keep mid on right because we want to increase it later.
            }
        }

        double increament = 0.1;
        for(int i = 0; i < precision; i++) {
            while(ans * ans <= number) {
                ans += increament;
            }

            ans -= increament; //the last value of ans is ans * ans > number, so minus one
            increament = increament / 10; //calculate next digit
        }

        return ans;
    }
}
