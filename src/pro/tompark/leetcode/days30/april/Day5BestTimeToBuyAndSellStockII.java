package pro.tompark.leetcode.days30.april;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time
 * x(i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class Day5BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        nums = new int[]{1,2,3,4,5};
        nums = new int[]{7,6,4,3,1};
        nums = new int[]{6,1,3,2,4,7};

        System.out.println(maxProfit2(nums));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyDay = 0;
        boolean hasStock = false;

        for (int i = 0; i < prices.length; i++) {
            int nextDay = i + 1;
            if (!hasStock) {
                // buy stock
                if (nextDay < prices.length && prices[nextDay] > prices[i]) {
                    buyDay = i;
                    hasStock = true;
                }
            } else {
                // sell stock
                if (prices[buyDay] < prices[i]) {
                    if (nextDay < prices.length) {
                        if (prices[nextDay] < prices[i]) {
                            maxProfit += prices[i] - prices[buyDay];
                            hasStock = false;
                        }
                    } else {
                        maxProfit += prices[i] - prices[buyDay];
                    }
                }
            }
        }

        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        return res;
    }
}
