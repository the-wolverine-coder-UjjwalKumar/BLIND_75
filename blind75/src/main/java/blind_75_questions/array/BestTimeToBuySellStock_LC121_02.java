package blind_75_questions.array;

public class BestTimeToBuySellStock_LC121_02 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int ans = getMaxProfitOptimized(prices);
        System.out.println(ans);
    }

    // BruteForce, TC : O(n^2), SC : O(1)
    private static int getMaxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int n = prices.length;
        for (int buyIndex = 0; buyIndex < n; buyIndex++) {
            for (int sellIndex = buyIndex+1; sellIndex < n; sellIndex++) {
                int buyValue = prices[buyIndex];
                int sellValue = prices[sellIndex];

                maxProfit = Math.max(maxProfit, (sellValue - buyValue));
            }
        }
        return maxProfit;
    }

    // TC : O(n), SC (1)
    private static int getMaxProfitOptimized(int[] prices) {
        int minBuySoFar = prices[0];
        int maxProfitSoFar = Integer.MIN_VALUE;
        int sellValue;

        for (int i = 1; i < prices.length; i++) {
            sellValue = prices[i];

            if (sellValue > minBuySoFar) {
                // sell the stock at given sell price and make profit
                maxProfitSoFar = Math.max(maxProfitSoFar, (sellValue - minBuySoFar));
            } else {
                // update the min buy so far
                minBuySoFar = prices[i];
            }
        }

        return maxProfitSoFar;

    }


}
