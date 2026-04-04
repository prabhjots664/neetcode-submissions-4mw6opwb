class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return ways(nums, nums.length-1, target);
    }

    private int ways(int[] nums, int i, int target) {
        if(i==-1 && target==0){
            return 1;
        }
        if(i==-1){
            return 0;
        }
        
        return ways(nums, i-1, target+nums[i]) + ways(nums, i-1, target-nums[i]);
    }
}
