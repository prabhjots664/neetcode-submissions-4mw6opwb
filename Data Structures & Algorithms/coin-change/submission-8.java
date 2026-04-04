class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-2);
        return helper(coins, amount, dp);
    }

    int helper(int[] coins, int amount, int[] dp){
        if(amount == 0){
            return 0;
        }
        if(amount <0){
            return -1;
        }

        if(dp[amount]!=-2){
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0; i<coins.length; i++){
            int subCount = helper(coins, amount-coins[i], dp);
            if(subCount!=-1){
                min = Math.min(min, 1 + subCount);
            }
        }

        if(min == Integer.MAX_VALUE){
            dp[amount] = -1;
            return -1;
        }
        dp[amount] = min;
        return min;
    }
}
