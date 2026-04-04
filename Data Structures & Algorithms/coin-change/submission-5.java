class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[999999];
        Arrays.fill(dp, -2);
        return coinChange2Recurse(coins, amount, dp);
    }

    private int coinChange2Recurse(int[] coins, int amount, int[] dp) {
        if(amount==0) return 0;
        if(amount<0) return -1;

        if(dp[amount]!=-2){
            return dp[amount];
        }
        
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int change = coinChange2Recurse(coins, amount-coins[i], dp);
            if(change>=0){
                min = Math.min(min, change);
            }
        }

        if(min!=Integer.MAX_VALUE){
            dp[amount] = 1+min;
        } else {
            dp[amount] = -1;
        }

        return dp[amount];
    }
}
