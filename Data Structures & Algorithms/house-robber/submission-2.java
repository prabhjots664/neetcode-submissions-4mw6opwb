class Solution {
    public int rob(int[] nums) {
        int[]dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return robHelper(nums, 0, dp);
    }

    int robHelper(int[] nums, int i, int[] dp){
        if(i>=nums.length){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int a = nums[i] + robHelper(nums, i+2, dp);
        int b = robHelper(nums, i+1, dp);
        dp[i] = Math.max(a,b);

        return dp[i];
    }

}
