/*
    N row of airplane seats [ABC DEFG HJK], notice there are two ales between C, D and G, H. Also, there is no char "I".

    S contains a string of occupied seats separated by space like "1A, 2F, 1C" where the first char is row number and
    the second one is seat number.

    Try to seat a family of 3. 3 numbers can't across ales.
    
 */
public class Solution {
    public int solution(int N, String S) {
        if(S == null) {
            return 0;
        }

        int ans = 0;
        int[][] left = new int[N][3];
        int[][] mid = new int[N][4];
        int[][] right = new int[N][3];
        String[] occupied = S.split(" ");
        if(S.length() > 0) {
            for (String s : occupied) {
                int row = Integer.parseInt(String.valueOf(s.charAt(0))) - 1;
                char c = s.charAt(1);
                int col = c >= 'J' ? c - 'A' - 1 : c - 'A';
                if (col >= 0 && col < 3) {
                    left[row][col] = 1;
                } else if (col >= 3 && col < 7) {
                    mid[row][col - 3] = 1;
                } else if (col >= 7 && col < 10) {
                    right[row][col - 7] = 1;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            ans += fitLeftOrRight(left, i) ? 1: 0;
            ans += fitLeftOrRight(right, i) ? 1: 0;
            ans += fitMid(mid, i) ? 1 : 0;
        }

        return ans;
    }

    boolean fitLeftOrRight(int[][] seats, int row) {
        for(int j = 0; j < 3; j++) {
            if(seats[row][j] == 1) {
                return false;
            }
        }

        return true;
    }

    boolean fitMid(int[][] seats, int row) {
        if(seats[row][1] == 1 || seats[row][2] == 1) {
            return false;
        } else if(seats[row][0] + seats[row][3] > 1) {
            return false;
        }

        return true;
    }
}
