class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[99999];
        Arrays.fill(dp,-2);
        return coinChange(coins, amount, dp);
    }

    public int coinChange(int[] coins, int amount, int[] dp) {

        if(amount==0) return 0;
        if(amount<0) return -1;

        if(dp[amount]>-2) return dp[amount];
        int min = 999999;
        for (int i = 0; i < coins.length; i++) {
            int subRes = coinChange(coins, amount-coins[i], dp);
            if(subRes < 0) continue;
            int res = subRes + 1;
            if(min>res){
                min=res;
            }
        }

        if(min == 999999){
            dp[amount] = -1;
        } else {
            dp[amount] = min;
        }
        return dp[amount];
    }
}
