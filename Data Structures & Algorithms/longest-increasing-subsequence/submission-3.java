class Solution {
    public int lengthOfLIS(int[] nums) {
        int longest = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        for (int i = 0; i < nums.length; i++) {
            if(longest<lis(nums, dp, i)){
                longest = lis(nums, dp, i);
            }
        }

        return longest;
    }

    private int lis(int[] nums, int[] dp, int idx) {
        int longest = 1;

        if(dp[idx]!=-1) return dp[idx];
        
        for (int i = 0; i < idx; i++) {
            if(nums[i]<nums[idx]){
                int lisi = lis(nums, dp, i);
                if(lisi+1 > longest){
                    longest = lisi+1;
                }
            }

        }

        dp[idx] = longest;
        return longest;
    }
}
