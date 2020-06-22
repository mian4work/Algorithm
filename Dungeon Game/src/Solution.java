/*
    The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon
    consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left
    room and must fight his way through the dungeon to rescue the princess.

    The knight has an initial health point represented by a positive integer. If at any point his health point drops
    to 0 or below, he dies immediately.

    Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;
    other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

    In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in
    each step.



    Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

    For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the
    optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

    -2 (K)	    -3	    3
    -5	        -10	    1
    10	        30	    -5 (P)


    Note:

    The knight's health has no upper bound.
    Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where
    the princess is imprisoned.
 */
public class Solution {
    /**
     * To solve this problem, we need to think backward: start from the cell(P):
     *      1. the last cell:
     *          if cell(P) < 0, K need Math.abs(cell(P)) + 1
     *          if cell(P) >= 0, K need 1 hp
     *      2. create a array hp where the last value hp(P) is set to above value
     *      3. for 1st row and 1st col of hp array:
     *          if cell(i) > 0 and > hp(i+1), hp(i) set to 1 (because K need at least 1 to be alive)
     *          if cell(i) > 0 and < hp(i+1), hp(i) set to hp(i+1) - cell(i)
     *          if cell(i) == hp(i+1), hp(i) set to 1
     *          if cell(i) < 0, hp(i) set to hp(i+1) - cell(i)
     *      4. for middle cells
     *          if cell(i)(j) > 0 and cell(i)(j) > min(hp(i+1)(j), cell(i)(j+1))
     *              hp(i)(j) set to 1
     *          if cell(i)(j) > 0 and cell(i)(j) < min(hp(i+1)(j), cell(i)(j+1))
     *              hp(i)(j) set to min(hp(i+1)(j), cell(i)(j+1)) - cell(i)(j)
     *          if cell(i)(j) > 0 and cell(i)(j) == min(hp(i+1)(j), cell(i)(j+1))
     *              hp(i)(j) set to 1
     *          if cell(i)(j) < 0, hp(j)(j) set to min(hp(i+1)(j), cell(i)(j+1)) + cell(i)(j)
     *
     *
     *  So, the algorithm is
     *
     *      hp(i)(j) = min(hp(i+1)(j), cell(i)(j+1)) - cell(i)(j)
     *      if hp(i)(j) <= 0, set hp(i)(j) = 1
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) {
            return 0;
        }

        int[][] hp = new int[dungeon.length][dungeon[0].length];
        //cell(P)
        hp[hp.length - 1][hp[0].length - 1] = dungeon[dungeon.length - 1][dungeon[0].length - 1] > 0 ?
                1 : Math.abs(dungeon[dungeon.length - 1][dungeon[0].length - 1]) + 1;
        //last column
        for(int i = dungeon.length - 2; i >= 0; i--) {
            int v = hp[i + 1][dungeon[0].length - 1] - dungeon[i][dungeon[0].length - 1];
            hp[i][dungeon[0].length - 1] = v <= 0 ? 1 : v;
        }

        //last row
        for(int j = dungeon[0].length - 2; j >= 0; j--) {
            int v = hp[dungeon.length - 1][j + 1] - dungeon[dungeon.length - 1][j];
            hp[dungeon.length - 1][j] = v <= 0 ? 1 : v;
        }

        //middle cells
        for(int i = dungeon.length - 2; i >= 0; i--) {
            for(int j = dungeon[0].length - 2; j >= 0; j--) {
                int v = Math.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j];
                hp[i][j] = v <= 0 ? 1 : v;
            }
        }

        return hp[0][0];
    }
}
