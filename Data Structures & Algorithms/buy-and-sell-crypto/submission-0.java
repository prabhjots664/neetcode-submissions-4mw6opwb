class Solution {
     public int maxProfit(int[] prices) {

        int[] futureMaxPrices = new int[prices.length];
        int maxPrice = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            if(prices[i]>maxPrice){
                maxPrice = prices[i];
            }
            futureMaxPrices[i] = maxPrice;
        }

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(maxProfit < (futureMaxPrices[i]-prices[i])){
                maxProfit = futureMaxPrices[i]-prices[i];
            }
        }
        return maxProfit;
    }
}
