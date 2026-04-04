class Solution {
    public int maxProfit(int[] prices) {
        return maxProfitRecurse(prices, 0, prices.length-1);
    }

    public int maxProfitRecurse(int[] prices, int start, int end) {
        if(start>=prices.length){
            return 0;
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
            remainingProfit = maxProfitRecurse(prices, sell+2, end);
            if(maxProfitOverAll < localMaxAtFixedSell + remainingProfit) {
                maxProfitOverAll = localMaxAtFixedSell + remainingProfit;
            }
        }

        return maxProfitOverAll;
    }
}
