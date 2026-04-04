class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length+1];
        Arrays.fill(dp, -1);
        return maxProfitRecurse(prices, 0, prices.length-1, dp);
    }

    public int maxProfitRecurse(int[] prices, int start, int end, int[] dp) {
        if(start>=prices.length){
            return 0;
        }

        if(dp[start]!=-1){
            return dp[start];
        }

        int[] minBuys = new int[prices.length+1];
        int minSoFar = 99999;
        for (int i = start; i <= end; i++) {
            if(minSoFar>prices[i]){
                minSoFar = prices[i];
            }
            minBuys[i+1] = minSoFar;
        }

        int maxProfitOverAll = 0;
        for (int sell = start+1; sell <= end; sell++) {
            int localMaxAtFixedSell = prices[sell] - minBuys[sell];
            int remainingProfit = 0;
            remainingProfit = maxProfitRecurse(prices, sell+2, end, dp);
            if(maxProfitOverAll < localMaxAtFixedSell + remainingProfit) {
                maxProfitOverAll = localMaxAtFixedSell + remainingProfit;
            }
        }

        dp[start] = maxProfitOverAll;

        return maxProfitOverAll;
    }
}
