class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][prices.length+1];
        for (int i = 0; i <= prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxProfitRecurse(prices, 0, prices.length-1, dp);
    }

    public int maxProfitRecurse(int[] prices, int start, int end, int[][] dp) {
        if(start>=prices.length){
            return 0;
        }

        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        
        int maxProfitOverAll = 0;
        for (int sell = start+1; sell <= end; sell++) {
            int localMaxAtFixedSell = 0;
            for (int buy = start; buy < sell; buy++) {
                int profit = prices[sell] - prices[buy];
                if(profit>localMaxAtFixedSell){
                    localMaxAtFixedSell = profit;
                }
            }
            int remainingProfit = 0;
            remainingProfit = maxProfitRecurse(prices, sell+2, end, dp);
            if(maxProfitOverAll < localMaxAtFixedSell + remainingProfit) {
                maxProfitOverAll = localMaxAtFixedSell + remainingProfit;
            }
        }

        dp[start][end] = maxProfitOverAll;

        return maxProfitOverAll;
    }
}
