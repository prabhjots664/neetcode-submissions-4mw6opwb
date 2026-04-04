class Solution {
     public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        int min1 = minCostStairsRecurse(cost, 0, dp);
        Arrays.fill(dp, -1);
        int min2 = minCostStairsRecurse(cost, 1, dp);
        return Math.min(min1, min2);
    }

    private int minCostStairsRecurse(int[] cost, int i, int[] dp) {

        if(i>=cost.length){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }

        dp[i] = cost[i] + Math.min(minCostStairsRecurse(cost, i+1, dp), minCostStairsRecurse(cost, i+2, dp));
        
        return dp[i];

    }
}
