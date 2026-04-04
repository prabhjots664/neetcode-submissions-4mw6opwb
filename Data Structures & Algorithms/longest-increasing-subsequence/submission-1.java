class Solution {
    public int lengthOfLIS(int[] nums) {
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if(longest<lis(nums, i)){
                longest = lis(nums, i);
            }
        }

        return longest;
    }

    private int lis(int[] nums, int idx) {
        int longest = 1;

        for (int i = 0; i < idx; i++) {
            if(nums[i]<nums[idx]){
                int lisi = lis(nums, i);
                if(lisi+1 > longest){
                    longest = lisi+1;
                }
            }

        }

        return longest;
    }
}
