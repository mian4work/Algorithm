import java.math.BigDecimal;
import java.math.RoundingMode;

/*
    The area of a circle is defined as πr^2. Estimate π to 3 decimal places
    using a Monte Carlo method.

    Hint: The basic equation of a circle is x2 + y2 = r2.
 */
public class Solution {

    /**
     * Reference link: https://www.geeksforgeeks.org/estimating-value-pi-using-monte-carlo/
     *
     * The Algorithm
     * 1. Initialize circle_points, square_points to 0.
     * 2. Generate random point x.
     * 3. Generate random point y.
     * 4. Calculate d = x*x + y*y.
     * 5. If d <= r^2, increment circle_points.
     * 6. Increment square_points.
     * 7. If increment < count, repeat from 2.
     * 8. Calculate pi = 4*(circle_points/square_points).
     * 9. Return.
     *
     * @param r The radius
     * @param count The number of repeat
     * @return
     */
    public double pi(int r, int count) {

        Double circlePoints = Double.valueOf(0.000), squarePoints = Double.valueOf(0.000);
        Double x, y;

        for(int i = 0; i < count; i++) {
            x = Math.random() * r;
            y = Math.random() * r;

            if(x * x + y * y <= r * r) {
                circlePoints++;
            }

            squarePoints++;
        }
        Double result = 4 * circlePoints / squarePoints;
        BigDecimal bd = new BigDecimal(result).setScale(3, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
