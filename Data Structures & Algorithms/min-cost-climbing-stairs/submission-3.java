class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(minfun(cost,dp, 0), minfun(cost, dp, 1));
    }

    int minfun(int[] cost, int[] dp, int i){
        if(i>=cost.length){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int a = minfun(cost, dp, i+1);
        int b = minfun(cost, dp, i+2);
        dp[i] = cost[i] + Math.min(a,b);
        return dp[i];
    }


}
