import java.util.Stack;
/*
    Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of
    that stock's price for the current day.

    The span of the stock's price today is defined as the maximum number of consecutive days
    (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

    For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
    then the stock spans would be [1, 1, 1, 2, 1, 4, 6].



    Example 1:

    Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
    Output: [null,1,1,1,2,1,4,6]
    Explanation:
    First, S = StockSpanner() is initialized.  Then:
    S.next(100) is called and returns 1,
    S.next(80) is called and returns 1,
    S.next(60) is called and returns 1,
    S.next(70) is called and returns 2,
    S.next(60) is called and returns 1,
    S.next(75) is called and returns 4,
    S.next(85) is called and returns 6.

    Note that (for example) S.next(75) returned 4, because the last 4 prices
    (including today's price of 75) were less than or equal to today's price.


    Note:

    Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
    There will be at most 10000 calls to StockSpanner.next per test case.
    There will be at most 150000 calls to StockSpanner.next across all test cases.
    The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 */
public class StockSpanner {
    Stack<Stock> stack = new Stack<>();
    public StockSpanner() {

    }

    /**
     * We can use a list to compare the price when calling next but it will exceed time limit.
     *
     * The best way to do it is to use a Stock object or simply use a two element array to hold val and span.
     * Then push each element to the a stack.
     *      1. when stack is empty or peek()'s val > price, push it with span == 1
     *      2. when peek()'s val <= price,
     *          keep pop element until it peek()'s value > price
     *          for each popped element, add up their spans
     *          then push the new price with new span into stack.
     *          
     * @param price
     * @return
     */
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().val <= price) {
            span += stack.pop().span;
        }
        stack.push(new Stock(price, span));
        return stack.peek().span;
    }
}

class Stock {
    int val = 0;
    int span = 1;
    public Stock(int val, int span) {
        this.val = val;
        this.span = span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */