import java.util.Comparator;
import java.util.PriorityQueue;

/*
    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

    (Here, the distance between two points on a plane is the Euclidean distance.)

    You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



    Example 1:

    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]
    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

    Example 2:

    Input: points = [[3,3],[5,-1],[-2,4]], K = 2
    Output: [[3,3],[-2,4]]
    (The answer [[-2,4],[3,3]] would also be accepted.)


    Note:

    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000
 */
public class Solution {
    /**
     * Done! A good use of limited size Priority Queue
     *
     * Nothing fancy, just calculate the distance and put in Ascending queue and limit it's size to K
     * the only thing needs attention is: implement a custom comparator for the queue.
     *
     * Another way to do it is to create a distance array and sort it. then get the first K element.
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length == 0) {
            return new int[][]{};
        }

        if(K >= points.length) {
            return points;
        }

        //use limited priority queue
        PriorityQueue<Element> queue = new PriorityQueue<>((e1, e2) -> {
            if(e2.distance < e1.distance) {
                return -1;
            } else if(e1.distance < e2.distance) {
                return 1;
            }
            return 0;
        });
        for(int[] point : points) {
            double distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            queue.add(new Element(distance, point));
            if(queue.size() > K) {
                queue.poll();
            }
        }

        int[][] ans = new int[queue.size()][2];
        int i = 0;
        while(!queue.isEmpty()) {
            int[] q = queue.poll().point;
            ans[i][0] = q[0];
            ans[i][1] = q[1];
            i++;
        }

        return ans;
    }

    class Element {
        double distance;
        int[] point;

        public Element(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }
    }
}
