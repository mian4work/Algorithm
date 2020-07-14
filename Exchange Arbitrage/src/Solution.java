/*
    This problem was asked by Jane Street.

    Suppose you are given a table of currency exchange rates, represented as a 2D array.
    Determine whether there is a possible arbitrage: that is, whether there is some sequence of trades you can make,
    starting with some amount A of any currency, so that you can end up with some amount greater than A of that currency.

    There are no transaction costs and you can trade fractional quantities.
 */
public class Solution {
    public boolean arbitrage(int[][] Exchange) {

        for(int i = 0; i < Exchange.length; i++) { //i is a selected currency
            double rate = 1.0;
            for(int j = 0; j != i && j < Exchange[i].length; j++) { //j are other currencies other than i
                for(int k = 0; k <= j; k++) { //k are currencies from beginning to currency j so we can try combination of exchange from 0 -> k
                    rate *= Exchange[i][k];
                }
                rate *= Exchange[j][i]; //exchange back to i

                if(rate > 1.0) {
                    return true;
                }
            }
        }

        return false;
    }
}
