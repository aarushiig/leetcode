package problems;

// DIFFICULTY   : Easy
// TOPICS       : Array, Dynamic Programming
public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.printf("MAX PROFIT: %d\t%d%n", maxProfitUsingBruteForce(prices1), maxProfitUsingDPAndSlidingWindow(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.printf("MAX PROFIT: %d\t%d%n", maxProfitUsingBruteForce(prices2), maxProfitUsingDPAndSlidingWindow(prices2));

        int[] prices3 = {0, 0, 15, 0, 9};
        System.out.printf("MAX PROFIT: %d\t%d%n", maxProfitUsingBruteForce(prices3), maxProfitUsingDPAndSlidingWindow(prices3));

        int[] prices4 = {7, 0, 0, 0, 0};
        System.out.printf("MAX PROFIT: %d\t%d%n", maxProfitUsingBruteForce(prices4), maxProfitUsingDPAndSlidingWindow(prices4));

        int[] prices5 = {0, 0, 0, 0, 0};
        System.out.printf("MAX PROFIT: %d\t%d%n", maxProfitUsingBruteForce(prices5), maxProfitUsingDPAndSlidingWindow(prices5));

        int[] prices6 = {7};
        System.out.printf("MAX PROFIT: %d\t%d%n", maxProfitUsingBruteForce(prices6), maxProfitUsingDPAndSlidingWindow(prices6));
    }

    /* CONSTRAINTS: 1 <= prices.length <= 10^5
                    0 <= prices[i] <= 10^4 */

    // TIME COMPLEXITY  : O(n^2)
    // SPACE COMPLEXITY : O(1)
    private static int maxProfitUsingBruteForce(int[] prices) {
        int maxProfit = 0;

        for (int buyDay = 0; buyDay < prices.length; buyDay++) {
            for (int sellDay = buyDay + 1; sellDay < prices.length; sellDay++) {
                maxProfit = Math.max(maxProfit, (prices[sellDay] - prices[buyDay]));
            }
        }

        return maxProfit;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static int maxProfitUsingDPAndSlidingWindow(int[] prices) {
        int maxProfit = 0;

        int sellDay = 1, buyDay = 0;
        while (sellDay < prices.length) {
            if (prices[sellDay] < prices[buyDay]) buyDay = sellDay;

            maxProfit = Math.max(maxProfit, (prices[sellDay] - prices[buyDay]));
            sellDay++;
        }

        return maxProfit;
    }
}
