class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return rob(nums, 0, dp);

        
    }

    public int rob(int[] nums, int i, int[] dp) {
        if(i>=nums.length){
            return 0;
        }

        if(dp[i]!=-1) return dp[i];

        int a = rob(nums, i+1, dp);

        int b = nums[i] + rob(nums, i+2, dp);

        return dp[i] = Math.max(a,b);
        
    }
}
