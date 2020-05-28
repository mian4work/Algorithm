import java.util.ArrayList;
import java.util.List;

/*
    Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling
    clockwise.
    array = [[1,2,3],
             [4,5,6],
             [7,8,9]]
    snail(array) #=> [1,2,3,6,9,8,7,4,5]
    For better understanding, please follow the numbers of the next array consecutively:
    array = [[1,2,3],
             [8,9,4],
             [7,6,5]]
    snail(array) #=> [1,2,3,4,5,6,7,8,9]
    This image will illustrate things more clearly:




    NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse the 2-d array
    in a clockwise snailshell pattern.
    NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].

 */
class Starbucks {
    public static void main(String[] args) {
        int[][] testArray = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = sort(3, 3, testArray);
        for (int i : list) {
            System.out.print(i + ",");
        }
    }

    static List<Integer> sort(int m, int n, int a[][]) {
        int row = 0, col = 0;
        int index = 0;
        List<Integer> list = new ArrayList<>();

        while (row < m && col < n) {
            //print the first row
            for (index = col; index < n; ++index) {
                list.add(a[row][index]);
            }
            row++;

            //print the last col
            for (index = row; index < m; ++index) {
                list.add(a[index][n - 1]);
            }
            n--;

            //print the last row backward
            if (row < m) {
                for (index = n - 1; index >= col; --index) {
                    list.add(a[m - 1][index]);
                }
                m--;
            }

            //print the first col bottom up
            if (col < n) {
                for (index = m - 1; index >= row; --index) {
                    list.add(a[index][col]);
                }
                col++;
            }
        }

        return list;
    }
}

